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
@Table(name = "Insurance")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Insurance_id")
    private long insuranceId;

    @ManyToOne
    @JoinColumn(name = "Patient_id", nullable = false)
    private PatientEntity patient;

    @Column(name = "Nombre_compania", nullable = false, length = 100)
    private String companyName;

    @Column(name = "Numero_poliza", nullable = false, unique = true, length = 30)
    private String policyNumber;

    @Column(name = "Estado_poliza", nullable = false)
    private boolean policyStatus;

    @Column(name = "Vigencia", nullable = false, length = 20)
    private String validity;

    public InsuranceEntity() {
    }

    public InsuranceEntity(long insuranceId, PatientEntity patient, String companyName,
            String policyNumber, boolean policyStatus, String validity) {
        this.insuranceId = insuranceId;
        this.patient = patient;
        this.companyName = companyName;
        this.policyNumber = policyNumber;
        this.policyStatus = policyStatus;
        this.validity = validity;
    }

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public boolean isPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(boolean policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }
}