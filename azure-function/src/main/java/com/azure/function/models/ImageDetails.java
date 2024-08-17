package com.azure.function.models;

import java.io.Serializable;

/**
 * This is used to read details
 * @author Sandeep Kumar
 *
 */
public class ImageDetails implements Serializable {

	private static final long serialVersionUID = 2873364799133588165L;
	private int resolution;
	private boolean enableCompression;
	private String compressionType;
	private String connectionString;
	private String containerName;

	public ImageDetails() {
		// no arg constructor
	}

	/**
	 * @return the resolution
	 */
	public int getResolution() {
		return resolution;
	}

	/**
	 * @param resolution
	 *            the resolution to set
	 */
	public void setResolution(int resolution) {
		this.resolution = resolution;
	}

	/**
	 * @return the enableCompression
	 */
	public boolean isEnableCompression() {
		return enableCompression;
	}

	/**
	 * @param enableCompression
	 *            the enableCompression to set
	 */
	public void setEnableCompression(boolean enableCompression) {
		this.enableCompression = enableCompression;
	}

	/**
	 * @return the compressionType
	 */
	public String getCompressionType() {
		return compressionType;
	}

	/**
	 * @param compressionType
	 *            the compressionType to set
	 */
	public void setCompressionType(String compressionType) {
		this.compressionType = compressionType;
	}

	/**
	 * @return the connectionString
	 */
	public String getConnectionString() {
		return connectionString;
	}

	/**
	 * @param connectionString
	 *            the connectionString to set
	 */
	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	/**
	 * @return the containerName
	 */
	public String getContainerName() {
		return containerName;
	}

	/**
	 * @param containerName
	 *            the containerName to set
	 */
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
}
