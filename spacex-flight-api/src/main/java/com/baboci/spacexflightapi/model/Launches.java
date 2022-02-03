package com.baboci.spacexflightapi.model;

public class Launches {

    private Boolean success;

    private Launches(){}

    public Launches( Boolean success) {

        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
