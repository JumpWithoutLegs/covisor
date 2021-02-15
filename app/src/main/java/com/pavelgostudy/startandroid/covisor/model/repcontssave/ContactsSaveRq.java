package com.pavelgostudy.startandroid.covisor.model.repcontssave;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.pavelgostudy.startandroid.covisor.model.Contact;
import com.pavelgostudy.startandroid.covisor.model.Temperature;

public class ContactsSaveRq {
    @SerializedName("empid")
    @Expose
    private String empid;
    @SerializedName("Comment")
    @Expose
    private String comment;
    @SerializedName("Contacts")
    @Expose
    private List<Contact> contacts = null;
    @SerializedName("Repcontdate")
    @Expose
    private String repcontdate;
    @SerializedName("temperats")
    @Expose
    private List<Temperature> temperats = null;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getRepcontdate() {
        return repcontdate;
    }

    public void setRepcontdate(String repcontdate) {
        this.repcontdate = repcontdate;
    }

    public List<Temperature> getTemperats() {
        return temperats;
    }

    public void setTemperats(List<Temperature> temperats) {
        this.temperats = temperats;
    }

}