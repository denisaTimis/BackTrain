package com.project.TrainApp;

public class Crs {

     private String type;
     private PropertiesCrs properties;

    public Crs() {
        this.type = "name";
        this.properties = new PropertiesCrs();;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertiesCrs getProperties() {
        return properties;
    }

    public void setProperties(PropertiesCrs properties) {
        this.properties = properties;
    }
}
