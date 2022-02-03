package com.baboci.spacexflightapi.model;

public class Dragon {
    private String name;
    private int orbit_duration_yr;

    public Dragon(){}

    public Dragon(String name, int orbit_duration_yr) {
        this.name = name;
        this.orbit_duration_yr = orbit_duration_yr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrbit_duration_yr() {
        return orbit_duration_yr;
    }

    public void setOrbit_duration_yr(int orbit_duration_yr) {
        this.orbit_duration_yr = orbit_duration_yr;
    }
}
