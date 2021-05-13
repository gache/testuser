package com.test.userpassword.models;

import javax.persistence.*;

@Entity
@Table(name = "compliance")
public class Compliance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean isValid;

    private String reason;

    public Compliance(boolean isPasswordValid, String reason) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", isValid=" + isValid +
                ", reason='" + reason + '\'' +
                '}';
    }
}
