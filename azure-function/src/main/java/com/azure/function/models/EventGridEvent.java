package com.azure.function.models;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Properties of an event published to an Event Grid topic.
 * @author Sandeep Kumar
 */
public class EventGridEvent {
    /**
     * An unique identifier for the event.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    /**
     * The resource path of the event source.
     */
    @JsonProperty(value = "topic")
    private String topic;

    /**
     * A resource path relative to the topic path.
     */
    @JsonProperty(value = "subject", required = true)
    private String subject;

    /**
     * Event data specific to the event type.
     */
    @JsonProperty(value = "data", required = true)
    private StorageBlobCreatedEventData data;

    /**
     * The type of the event that occurred.
     */
    @JsonProperty(value = "eventType", required = true)
    private String eventType;

    /**
     * The time (in UTC) the event was generated.
     */
    @JsonProperty(value = "eventTime", required = false)
    private String eventTime;

    /**
     * The schema version of the event metadata.
     */
    @JsonProperty(value = "metadataVersion", access = JsonProperty.Access.WRITE_ONLY)
    private String metadataVersion;

    /**
     * The schema version of the data object.
     */
    @JsonProperty(value = "dataVersion", required = true)
    private String dataVersion;

    /**
     * Creates an instance of EventGridEvent class.
     * @param id an unique identifier for the event.
     * @param subject a resource path relative to the topic path.
     * @param data event data specific to the event type.
     * @param eventType the type of the event that occurred.
     * @param eventTime the time (in UTC) the event was generated.
     * @param dataVersion the schema version of the data object.
     */
    public EventGridEvent(String id, String subject, StorageBlobCreatedEventData data, String eventType, String eventTime, String dataVersion) {
        this.id = id;
        this.subject = subject;
        this.data = data;
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.dataVersion = dataVersion;
    }

    /**
     * Private constructor for deserialization.
     */
    EventGridEvent() {
    }

    /**
     * Get an unique identifier for the event.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Get the resource path of the event source.
     *
     * @return the topic value
     */
    public String topic() {
        return this.topic;
    }

    /**
     * Set the resource path of the event source.
     *
     * @param topic the topic value to set
     * @return the EventGridEvent object itself.
     */
    public EventGridEvent withTopic(String topic) {
        this.topic = topic;
        return this;
    }

    /**
     * Get a resource path relative to the topic path.
     *
     * @return the subject value
     */
    public String subject() {
        return this.subject;
    }

    /**
     * Get event data specific to the event type.
     *
     * @return the data value
     */
    public StorageBlobCreatedEventData data() {
        return this.data;
    }

    /**
     * Get the type of the event that occurred.
     *
     * @return the eventType value
     */
    public String eventType() {
        return this.eventType;
    }

    /**
     * Get the time (in UTC) the event was generated.
     *
     * @return the eventTime value
     */
    public String eventTime() {
        return this.eventTime;
    }

    /**
     * Get the schema version of the event metadata.
     *
     * @return the metadataVersion value
     */
    public String metadataVersion() {
        return this.metadataVersion;
    }

    /**
     * Get the schema version of the data object.
     *
     * @return the dataVersion value
     */
    public String dataVersion() {
        return this.dataVersion;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Object getData() {
		return data;
	}

	public void setData(StorageBlobCreatedEventData data) {
		this.data = data;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getMetadataVersion() {
		return metadataVersion;
	}

	public void setMetadataVersion(String metadataVersion) {
		this.metadataVersion = metadataVersion;
	}

	public String getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(String dataVersion) {
		this.dataVersion = dataVersion;
	}

    
    
}
