package com.baboci.spacexflightapi.model;

public class RocketPayloadWeight {
    private String id;
    private String name;
    private int kg;
    private int lb;

    public RocketPayloadWeight(){}

    public RocketPayloadWeight(String id, String name, int kg, int lb) {
        this.id = id;
        this.name = name;
        this.kg = kg;
        this.lb = lb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }
}
