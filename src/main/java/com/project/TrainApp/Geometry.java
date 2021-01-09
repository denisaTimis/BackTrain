package com.project.TrainApp;

import java.util.List;

public class Geometry
{
    private String type;
    private List<List<List<Double>>> coordinates;

    public Geometry( List<List<List<Double>>> coordinates) {
        this.type = "MultiLineString";
        this.coordinates = coordinates;
    }
    public Geometry(){}

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinates(List<List<List<Double>>> coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public List<List<List<Double>>> getCoordinates() {
        return coordinates;
    }
}
