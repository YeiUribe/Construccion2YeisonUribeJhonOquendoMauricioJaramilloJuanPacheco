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
@Table(name = "clinical_record")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinical_record_id")
    private long clinicalRecordId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @Column(name = "Fecha_creacion", nullable = false, length = 20)
    private String creationDate;

    @Column(name = "Diagnostico", nullable = false, length = 500)
    private String diagnosis;

    @Column(name = "Tratamiento", nullable = false, length = 500)
    private String treatment;

    @Column(name = "Observaciones", length = 500)
    private String observations;

    @Column(name = "Activo", nullable = false)
    private boolean isActive;

    public ClinicalRecordEntity() {
    }

    public ClinicalRecordEntity(long clinicalRecordId, PatientEntity patient, UserEntity doctor,
            String creationDate, String diagnosis, String treatment,
            String observations, boolean isActive) {
        this.clinicalRecordId = clinicalRecordId;
        this.patient = patient;
        this.doctor = doctor;
        this.creationDate = creationDate;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.observations = observations;
        this.isActive = isActive;
    }

    public long getClinicalRecordId() {
        return clinicalRecordId;
    }

    public void setClinicalRecordId(long clinicalRecordId) {
        this.clinicalRecordId = clinicalRecordId;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}