package com.project.TrainApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

public class RouteVector {

    private String type;
    private List<Feature> features;

    public RouteVector( List<Feature>  features) {
        this.type = "FeatureCollection";
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public List<Feature>  getFeatures() {
        return features;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFeatures(List<Feature>  features) {
        this.features = features;
    }
}
