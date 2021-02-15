package com.pavelgostudy.startandroid.covisor.model.repcontsspis;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pavelgostudy.startandroid.covisor.model.Contact;
import com.pavelgostudy.startandroid.covisor.model.Temperature;

public class ContactsListRs {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("repid")
    @Expose
    private String repid;
    @SerializedName("temperat")
    @Expose
    private Double temperat;
    @SerializedName("contacts")
    @Expose
    private List<Contact> contacts = null;
    @SerializedName("temperats")
    @Expose
    private List<Temperature> temperatures = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRepid() {
        return repid;
    }

    public void setRepid(String repid) {
        this.repid = repid;
    }

    public Double getTemperat() {
        return temperat;
    }

    public void setTemperat(Double temperat) {
        this.temperat = temperat;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(List<Temperature> temperatures) {
        this.temperatures = temperatures;
    }


    @Override
    public String toString() {
        return "ContactsListRs{" +
                "success=" + success +
                ", date='" + date + '\'' +
                ", repid='" + repid + '\'' +
                ", temperat=" + temperat +
                ", contacts=" + contacts +
                ", temperatures=" + temperatures +
                '}';
    }
}