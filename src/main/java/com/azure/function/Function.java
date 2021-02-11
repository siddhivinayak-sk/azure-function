package com.azure.function;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.logging.Level;

import org.yaml.snakeyaml.Yaml;

import com.azure.function.models.EventGridEvent;
import com.azure.function.models.StorageBlobCreatedEventData;
import com.azure.function.utils.AzureStorageUtils;
import com.azure.function.utils.ImageUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.EventGridTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;

public class Function {

	private static final String CONTAINER_URL = ".blob.core.windows.net";
	private static final String STORAGE_BLOB = "storageblobcreatedevent";
	private static final String BITONAL = "bitonal";
	private static final String GRAY = "gray";
	private static final String CONNECTION_STRING = "connectionString";
	private static final String TIFF = ".tiff";
	private static final String TIF = ".tif";
	private static final String GRAY_PATH = "/gray/";
	private static final String APPLICATION_YAML = "application.yaml";

	/**
	 * EventGrid trigger function for handling the events and log them to the
	 * execution context.
	 */
	@FunctionName("my-azure-function")
	public void Run(@EventGridTrigger(name = "data") String data, final ExecutionContext executionContext) {
		executionContext.getLogger().info("Java EventGrid trigger function begun\n");
		executionContext.getLogger().info("Data: " + data);
		Map<String, Object> yamlProperties = loadYamlFile(executionContext);
		executionContext.getLogger().info("Yaml Loading");
		try {
			final String StorageBlobCreatedEvent = (String) yamlProperties.get(STORAGE_BLOB);
			executionContext.getLogger().info("StorageBlobCreatedEvent  Created");
			final Gson gson = new GsonBuilder().create();
			executionContext.getLogger().info("GSON Created");
			EventGridEvent eventGridEvent = gson.fromJson(data, EventGridEvent.class);
			executionContext.getLogger().info("EventGridEvent Cast to Java POJO");
			if (eventGridEvent.eventType().equalsIgnoreCase(StorageBlobCreatedEvent)) {
				executionContext.getLogger().info("EventGridEvent - Blob Created Event");
				StorageBlobCreatedEventData eventData = eventGridEvent.data();
				executionContext.getLogger().info("EventGridEvent - Event Info Obtained");
				String url = eventData.url(); 
				executionContext.getLogger().info("EventGridEvent URI: " + url);
				if(url.contains(GRAY_PATH) && (url.endsWith(TIF) || url.endsWith(TIFF))) {
					executionContext.getLogger().info("URI is Eligible to perform G2B");
					Boolean enableCompression = (Boolean) yamlProperties.get("enableCompression");
					executionContext.getLogger().info("Param - enableCompression" + enableCompression);
					String compressionType = (String) yamlProperties.get("compressionType");
					executionContext.getLogger().info("Param - compressionType" + compressionType);
					int resolution = (int) yamlProperties.get("resolution");
					executionContext.getLogger().info("Param - resolution" + resolution);
					String connectionString = (String) yamlProperties.get(CONNECTION_STRING);
					executionContext.getLogger().info("Obtaining Bitonal URI");
					String grayFilePath = url;
					int startContainer = url.indexOf(CONTAINER_URL) + 23;
					String containerName = url.substring(startContainer).substring(0,
							url.substring(startContainer).indexOf('/'));
					grayFilePath = grayFilePath.substring(startContainer + containerName.length() + 1);
					String bitonalFilePath = grayFilePath.replace(GRAY, BITONAL);
					executionContext.getLogger().info("Bitonal URI: " + bitonalFilePath);
					InputStream inputStream = AzureStorageUtils.download(connectionString, containerName, grayFilePath);
					executionContext.getLogger().info("Input Image Obtained");
					OutputStream outputStream = AzureStorageUtils.upload(connectionString, containerName, bitonalFilePath);
					executionContext.getLogger().info("Output Image Obtained");
					ImageUtil.convert(inputStream, outputStream, enableCompression, compressionType, resolution, executionContext.getLogger());
					executionContext.getLogger().info("Processing Completed");
					try {
						inputStream.close();
					}
					catch(IOException ex) {
						executionContext.getLogger().log(Level.SEVERE, "IOException Occurred in Input", ex);
					}
					try {
						outputStream.close();
					}
					catch(IOException ex) {
						executionContext.getLogger().log(Level.SEVERE, "IOException Occurred in Output", ex);
					}
				}
			}
		} catch (Exception e) {
			executionContext.getLogger().log(Level.SEVERE, "Global Exception", e);
		}
	}

	public Map<String, Object> loadYamlFile(ExecutionContext executionContext) {
		executionContext.getLogger().info("Inside the G2BConverterServiceImpl:: loadYamlFile method");
		Yaml yaml = new Yaml();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(APPLICATION_YAML);
		Map<String, Object> yamlProperties = yaml.load(inputStream);
		return yamlProperties;
	}

}
