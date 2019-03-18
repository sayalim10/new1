package com.devn.delivery.http.utils;

import com.google.gson.annotations.Expose;

public class AuthData {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Expose
    private String status;
}
