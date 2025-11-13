package app.adapter.rest.response;

import java.time.LocalDate;

public class InvoiceResponse {
    private long id;
    private LocalDate issueDate;
    private String patientId;
    private String patientName;
    private String doctorId;
    private String doctorName;
    private double totalAmount;
    private double copayAmount;

    public InvoiceResponse() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getCopayAmount() { return copayAmount; }
    public void setCopayAmount(double copayAmount) { this.copayAmount = copayAmount; }
}
