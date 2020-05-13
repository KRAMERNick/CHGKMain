package com.example.chgk.MVP.Model;

public class Raitng implements IRating{
    private String name;
    private float average;

    public Raitng(String name, float average) {
        this.name = name;
        this.average = average;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Float getAverage() {
        return average;
    }
}
