package app.domain.model;

import java.time.LocalDate;

public class Invoice {

    private long id;
    private LocalDate issueDate;
    private Patient patient;
    private User doctor;
    private double totalAmount;
    private double copayAmount;

    public Invoice() {
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getCopayAmount() {
        return copayAmount;
    }

    public void setCopayAmount(double copayAmount) {
        this.copayAmount = copayAmount;
    }
}

