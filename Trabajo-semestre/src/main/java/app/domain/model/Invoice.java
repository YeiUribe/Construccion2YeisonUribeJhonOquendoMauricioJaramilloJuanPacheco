package app.domain.model;

public class Invoice {

    private String id;
    private String issueDate;
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

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
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

