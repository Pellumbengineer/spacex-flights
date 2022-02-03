package com.baboci.spacexflightapi.model;

import java.util.List;

public class Rocket {

    private List<RocketPayloadWeight> payload_weights;
    private String name;
    private int success_rate_pct;

    public Rocket(){}

    public Rocket(List<RocketPayloadWeight> payload_weights, String name, int success_rate_pct) {
        this.payload_weights = payload_weights;
        this.name = name;
        this.success_rate_pct = success_rate_pct;
    }

    public List<RocketPayloadWeight> getPayload_weights() {
        return payload_weights;
    }

    public void setPayload_weights(List<RocketPayloadWeight> payload_weights) {
        this.payload_weights = payload_weights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSuccess_rate_pct() {
        return success_rate_pct;
    }

    public void setSuccess_rate_pct(int success_rate_pct) {
        this.success_rate_pct = success_rate_pct;
    }
}
