package com.test.userpassword.models;

public class ValidationResponse {

    private final String description;
    private final Compliance compliance;

    public ValidationResponse(ResultValidation resultValidation) {
        this.description = resultValidation.getDescription();
        this.compliance = resultValidation.getResult();
    }


    public String getDescription() {
        return description;
    }

    public Compliance getCompliance() {
        return compliance;
    }
}
