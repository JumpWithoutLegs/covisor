package com.pavelgostudy.startandroid.covisor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("contid")
    @Expose
    private String contid;
    @SerializedName("placecont")
    @Expose
    private String placecont;
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

    public String getPlacecont() {
        return placecont;
    }

    public void setPlacecont(String placecont) {
        this.placecont = placecont;
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

    @Override
    public String toString() {
        return "Contact{" +
                "contid='" + contid + '\'' +
                ", placecont='" + placecont + '\'' +
                ", fiocont='" + fiocont + '\'' +
                ", status='" + status + '\'' +
                ", group=" + group +
                '}';
    }
}