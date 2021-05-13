package com.test.userpassword.models;

public class ResultValidation {

    private final int statusCode;
    private final String description;
    private final Compliance result;


    public ResultValidation(int statusCode, String description, Compliance result) {
        this.statusCode = statusCode;
        this.description = description;
        this.result = result;
    }



    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public Compliance getResult() {
        return result;
    }
}
