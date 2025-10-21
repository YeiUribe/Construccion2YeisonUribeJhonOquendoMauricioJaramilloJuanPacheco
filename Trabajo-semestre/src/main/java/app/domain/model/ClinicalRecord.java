package app.domain.model;

import java.time.LocalDate;

public class ClinicalRecord {

    private Patient patient;
    private User doctor;
    private LocalDate recordDate;
    private PatientVitals vitals;
    private String reasonForVisit;
    private String symptoms;
    private String diagnosis;
    private ClinicalOrder clinicalOrder;

    public ClinicalRecord() {
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

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    public PatientVitals getVitals() {
        return vitals;
    }

    public void setVitals(PatientVitals vitals) {
        this.vitals = vitals;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public ClinicalOrder getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrder clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }
}
