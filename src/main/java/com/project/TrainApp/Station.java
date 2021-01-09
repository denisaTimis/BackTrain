package com.project.TrainApp;

import javax.persistence.*;

@Entity
@Table(name = "STATION", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })

public class Station {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @Column(name = "LATITUDINE",nullable = false)
    private double lat;

    @Column(name = "LONGITUDINE",nullable = false)
    private double lon;

    public Station(int id, String name, double lon , double lat)
    {
        this.id=id;
        this.name=name;
        this.lat=lat;
        this.lon=lon;
    }
    public Station(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name= name; }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) { this.lon = lon; }

}