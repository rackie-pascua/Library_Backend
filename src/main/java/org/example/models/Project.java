package org.example.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
    private String name;
    private double value;
    private int client;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(final double value) {
        this.value = value;
    }

    public int getClient() {
        return client;
    }

    public void setClient(final int client) {
        this.client = client;
    }

    @JsonCreator
    public Project(
           final @JsonProperty("name") String name,
           final @JsonProperty("value") double value,
           final @JsonProperty("client") int client) {
        this.name = name;
        this.value = value;
        this.client = client;
    }
}
