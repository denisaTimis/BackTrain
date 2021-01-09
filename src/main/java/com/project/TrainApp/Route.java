package com.project.TrainApp;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROUTE", uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class Route {

    @Id
    @Column(name = "ID")
    private int id;

    @ManyToMany
    @JoinColumn(name="STATIONS",referencedColumnName = "ID")
    private List<Station> stations;

    @Column(name = "DATE",nullable = false)
    private String date;

    @Column(name = "TIME",nullable = false)
    private String time;

    public Route(int id, List<Station> stations, String date, String time)
    {
        this.id=id;
        this.stations=stations;
        this.date=date;
        this.time=time;
    }

    public Route() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) { this.time = time; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Station> getStations()
    {
        return stations;
    }
    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}