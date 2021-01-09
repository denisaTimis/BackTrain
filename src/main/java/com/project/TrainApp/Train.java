package com.project.TrainApp;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "TRAIN", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Train {

    @Id
    @Column(name = "ID")
    private int id;

    @OneToOne
    @JoinColumn(name="ROUTE",referencedColumnName = "ID")
    private Route route;

    @Column(name = "SITS",nullable = false)
    private int sits;

    @Column(name = "WAGGONS",nullable = false)
    private int waggons;

    @Column(name = "PRICE",nullable = false)
    private int price;

    @Column(name = "TIME",nullable = false)
    private String time;

    @Column(name = "DEPARTURE_TIME",nullable = false)
    private String departureTime;

    @Column(name = "ARRIVAL_TIME",nullable = false)
    private String arrivalTime;

    @Column(name = "TRAIN_KIND",nullable = false)
    private String trainKind;

    public Train(int id, Route route, int sits, int waggons, int price, String time, String departureTime, String arrivalTime, String trainKind)
    {
        this.id=id;
        this.route=route;
        this.sits=sits;
        this.waggons=waggons;
        this.price=price;
        this.time=time;
        this.departureTime=departureTime;
        this.arrivalTime=arrivalTime;
        this.trainKind=trainKind;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Integer getSits() {
        return sits;
    }

    public void setSits(Integer sits) {
        this.sits = sits;
    }

    public Integer getWagons() {
        return waggons;
    }

    public void setWaggons(Integer waggons) {
        this.waggons = waggons;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTrainKind() {
        return trainKind;
    }

    public void setTrainKind(String trainKind) {
        this.trainKind = trainKind;
    }

    public Train() {}
}

