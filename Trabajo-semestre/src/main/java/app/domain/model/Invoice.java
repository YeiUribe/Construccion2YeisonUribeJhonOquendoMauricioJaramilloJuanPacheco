package app.domain.model;

import java.util.Date;

public class Invoice {

    private String id;
    private Date issueDate;
    private Patient patient;
    private User doctor;
    private String totalAmount;
    private String copayAmount;

    public Invoice() {
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCopayAmount() {
        return copayAmount;
    }

    public void setCopayAmount(String copayAmount) {
        this.copayAmount = copayAmount;
    }
}

