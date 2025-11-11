package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long invoiceId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private InsuranceEntity insurance;

    @Column(name = "Numero_poliza", length = 30)
    private String policyNumber;

    @Column(name = "Dias_vigencia", nullable = false)
    private int daysOfValidity;

    @Column(name = "Fecha_finalizacion", nullable = false, length = 20)
    private String endDate;

    @Column(name = "Costo_total", nullable = false)
    private double totalCost;

    @Column(name = "Copago", nullable = false)
    private double copayment;

    @Column(name = "Detalle", columnDefinition = "TEXT")
    private String details;

    public InvoiceEntity() {
    }

    public InvoiceEntity(long invoiceId, PatientEntity patient, UserEntity doctor,
            InsuranceEntity insurance, String policyNumber,
            int daysOfValidity, String endDate,
            double totalCost, double copayment, String details) {
        this.invoiceId = invoiceId;
        this.patient = patient;
        this.doctor = doctor;
        this.insurance = insurance;
        this.policyNumber = policyNumber;
        this.daysOfValidity = daysOfValidity;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.copayment = copayment;
        this.details = details;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public UserEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(UserEntity doctor) {
        this.doctor = doctor;
    }

    public InsuranceEntity getInsurance() {
        return insurance;
    }

    public void setInsurance(InsuranceEntity insurance) {
        this.insurance = insurance;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public int getDaysOfValidity() {
        return daysOfValidity;
    }

    public void setDaysOfValidity(int daysOfValidity) {
        this.daysOfValidity = daysOfValidity;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getCopayment() {
        return copayment;
    }

    public void setCopayment(double copayment) {
        this.copayment = copayment;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
