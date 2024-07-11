package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectClient {
    @JsonProperty
    private int client_id;
    @JsonProperty
    private String client_name;

    public ProjectClient(int client_id, String client_name) {
        this.client_id = client_id;
        this.client_name = client_name;
    }
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
}
