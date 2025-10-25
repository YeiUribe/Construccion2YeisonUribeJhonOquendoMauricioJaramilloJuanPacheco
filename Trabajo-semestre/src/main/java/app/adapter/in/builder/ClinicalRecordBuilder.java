package app.adapter.in.builder;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.PatientVitals;
import app.domain.model.ClinicalOrder;
import java.time.LocalDate;

public class ClinicalRecordBuilder {
    private Patient patient;
    private User doctor;
    private LocalDate recordDate;
    private PatientVitals vitals;
    private String reasonForVisit;
    private String symptoms;
    private String diagnosis;
    private ClinicalOrder clinicalOrder;

    public static ClinicalRecordBuilder builder() {
        return new ClinicalRecordBuilder();
    }

    public ClinicalRecordBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public ClinicalRecordBuilder withDoctor(User doctor) {
        this.doctor = doctor;
        return this;
    }

    public ClinicalRecordBuilder withRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
        return this;
    }

    public ClinicalRecordBuilder withVitals(PatientVitals vitals) {
        this.vitals = vitals;
        return this;
    }

    public ClinicalRecordBuilder withReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
        return this;
    }

    public ClinicalRecordBuilder withSymptoms(String symptoms) {
        this.symptoms = symptoms;
        return this;
    }

    public ClinicalRecordBuilder withDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
        return this;
    }

    public ClinicalRecordBuilder withClinicalOrder(ClinicalOrder clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
        return this;
    }

    public ClinicalRecord build() {
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setPatient(patient);
        clinicalRecord.setDoctor(doctor);
        clinicalRecord.setRecordDate(recordDate);
        clinicalRecord.setVitals(vitals);
        clinicalRecord.setReasonForVisit(reasonForVisit);
        clinicalRecord.setSymptoms(symptoms);
        clinicalRecord.setDiagnosis(diagnosis);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        return clinicalRecord;
    }
}