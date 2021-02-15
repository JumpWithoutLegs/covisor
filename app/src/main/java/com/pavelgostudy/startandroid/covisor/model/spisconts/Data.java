package com.pavelgostudy.startandroid.covisor.model.spisconts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("contid")
    @Expose
    private String contid;
    @SerializedName("empid")
    @Expose
    private String empid;
    @SerializedName("fiocont")
    @Expose
    private String fiocont;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("group")
    @Expose
    private Integer group;

    public String getContid() {
        return contid;
    }

    public void setContid(String contid) {
        this.contid = contid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getFiocont() {
        return fiocont;
    }

    public void setFiocont(String fiocont) {
        this.fiocont = fiocont;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

}