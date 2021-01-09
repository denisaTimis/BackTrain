package com.project.TrainApp;

public class Property {

    private String kind;
    private String from;
    private String to;

    public Property( String from, String to)
    {
        this.kind = "route";
        this.from = from;
        this.to = to;
    }

    public String getKind() {
        return kind;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
