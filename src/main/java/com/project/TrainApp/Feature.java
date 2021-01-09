package com.project.TrainApp;

public class Feature {

    private String type;
    private Property properties;
    private Geometry geometry;

    public Feature( Property properties, Geometry geometry) {
        this.type = "Feature";
        this.properties = properties;
        this.geometry = geometry;
    }

    public String getType() {
        return type;
    }

    public Property getProperties() {
        return properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProperties(Property properties) {
        this.properties = properties;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
