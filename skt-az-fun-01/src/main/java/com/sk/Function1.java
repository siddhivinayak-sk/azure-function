package com.sk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.EventGridTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.sk.model.EventGridEvent;

public class Function1 {

	@FunctionName("fun01")
    public void run(@EventGridTrigger(name = "data") String data, final ExecutionContext context) {
        context.getLogger().info("Received event");
        context.getLogger().info("Raw Data: " + data);
        final Gson gson = new GsonBuilder().create();
        EventGridEvent eventGridEvent = gson.fromJson(data, EventGridEvent.class);
        context.getLogger().info("Data received: " + eventGridEvent);
        context.getLogger().info("Event Processed");
    }
}
