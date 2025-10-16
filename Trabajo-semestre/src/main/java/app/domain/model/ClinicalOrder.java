package app.domain.model;

import java.time.LocalDate;

import java.util.List;

public class ClinicalOrder {

    private long id;
    private Patient patient;
    private User doctor;
    private LocalDate creationDate;
    private List<Medication> medications;
    private List<Procedure> procedures;
    private List<DiagnosticAid> diagnosticAids;

    public ClinicalOrder() {
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    public List<DiagnosticAid> getDiagnosticAids() {
        return diagnosticAids;
    }

    public void setDiagnosticAids(List<DiagnosticAid> diagnosticAids) {
        this.diagnosticAids = diagnosticAids;
    }
}
