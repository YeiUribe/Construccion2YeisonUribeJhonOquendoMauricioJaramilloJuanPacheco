package app.domain.model;

public class Invoice {

    private String id;
    private String issueDate;
    private Patient patient;
    private User doctor;
    private String totalAmount;
    private int copayAmount;

    public Invoice() {
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String string) {
        this.issueDate = string;
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

    public void setTotalAmount(String string) {
        this.totalAmount = string;
    }

    public int getCopayAmount() {
        return copayAmount;
    }

    public void setCopayAmount(int i) {
        this.copayAmount = i;
    }


}
