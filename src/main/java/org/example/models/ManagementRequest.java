package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ManagementRequest {
    private String name;
    private int client_id;
    private double value;


    @JsonCreator
    public ManagementRequest(
            @JsonProperty("name") String name,
            @JsonProperty("client_id") int client_id,
            @JsonProperty("value") double value)
    {
        this.name = name;
        this.client_id = client_id;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
