package com.pavelgostudy.startandroid.covisor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("temperat")
    @Expose
    private Double temperat;
    @SerializedName("time")
    @Expose
    private String time;

    public Double getTemperat() {
        return temperat;
    }

    public void setTemperat(Double temperat) {
        this.temperat = temperat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}