package com.project.TrainApp;

public class SearchTrainRequest {

    private int id;
    private String departure;
    private String arrival;
    private String date;
    private String trainId;
    private boolean inTransit;

    public SearchTrainRequest(int id, String departure, String arrival, String date)
    {
        this.id=id;
        this.departure=departure;
        this.arrival=arrival;
        this.date=date;
        trainId=Integer.toString(id);
        if(id==2)
            inTransit = false;
        else
            inTransit=true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInTransit() {
        return inTransit;
    }

    public void setInTransit(boolean inTransit) {
        this.inTransit = inTransit;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getDeparture()
    {
        return departure;
    }
    public void setDeparture(String departure)
    {
        this.departure=departure;
    }
    public String getArrival()
    {
        return arrival;
    }
    public void setArrival(String arrival)
    {
        this.arrival=arrival;
    }
    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date=date;
    }

    public SearchTrainRequest(){}
}

