package com.test.userpassword.models;


public class Compliance {


    private boolean isValid;

    private String reason;

    public Compliance(boolean isValid, String reason) {
        this.isValid = isValid;
        this.reason = reason;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                ", isValid=" + isValid +
                ", reason='" + reason + '\'' +
                '}';
    }
}
