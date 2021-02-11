package com.azure.function;

import java.util.logging.Logger;

import org.junit.Test;

import com.microsoft.azure.functions.ExecutionContext;

/**
 * Unit test for Function class.
 */
public class FunctionTest {
	
	private static Logger logger = Logger.getLogger(FunctionTest.class.getName());
	
	@Test
	public void RunTest() {
		ExecutionContext executionContext = new ExecutionContext() {

			@Override
			public Logger getLogger() {
				return logger;
			}

			@Override
			public String getInvocationId() {
				return null;
			}

			@Override
			public String getFunctionName() {
				return "my-azure-function";
			}};
			
			/**
			 * Enter here the path of BlockBlob file URL for testing purpuse
			 */
			String data = "{\"topic\":\"\",\"subject\":\"\",\"eventType\":\"Microsoft.Storage.BlobCreated\",\"id\":\"\",\"data\":{\"api\":\"\",\"clientRequestId\":\"\",\"requestId\":\"\",\"eTag\":\"\",\"contentType\":\"\",\"contentLength\":19117,\"blobType\":\"BlockBlob\",\"url\":\"<enter url>\",\"sequencer\":\"\",\"storageDiagnostics\":{\"batchId\":\"\"}},\"dataVersion\":\"\",\"metadataVersion\":\"1\",\"eventTime\":\"2021-02-01T10:32:58.1406068Z\"}";
			Function function = new Function();
			function.Run(data, executionContext);
	}
}
