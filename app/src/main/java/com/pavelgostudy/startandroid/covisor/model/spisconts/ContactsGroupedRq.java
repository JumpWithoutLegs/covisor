package com.pavelgostudy.startandroid.covisor.model.spisconts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactsGroupedRq {
    @SerializedName("Empid")
    @Expose
    private String empid;
    @SerializedName("group")
    @Expose
    private Integer group;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

}