package com.pavelgostudy.startandroid.covisor.model.conts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactsUpdateRq {
    @SerializedName("Empid")
    @Expose
    private String empid;
    @SerializedName("contid")
    @Expose
    private String contid;
    @SerializedName("fiocont")
    @Expose
    private String fiocont;
    @SerializedName("group")
    @Expose
    private Integer group;
    @SerializedName("status")
    @Expose
    private String status;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getContid() {
        return contid;
    }

    public void setContid(String contid) {
        this.contid = contid;
    }

    public String getFiocont() {
        return fiocont;
    }

    public void setFiocont(String fiocont) {
        this.fiocont = fiocont;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}