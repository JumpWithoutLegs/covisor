package com.pavelgostudy.startandroid.covisor.model.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthRs {

    @SerializedName("fio")
    @Expose
    private String fio;
    @SerializedName("empid")
    @Expose
    private String empid;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("success")
    @Expose
    private Boolean success;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

}