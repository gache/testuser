package com.test.userpassword.models;

public class ResultValidation {

    private final int statusCode;
    private final String description;

    public ResultValidation(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

}
