package app.adapter.in.builder;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Medication;
import app.domain.model.Procedure;
import app.domain.model.DiagnosticAid;
import java.time.LocalDate;
import java.util.List;

public class ClinicalOrderBuilder {
    private long id;
    private Patient patient;
    private User doctor;
    private LocalDate creationDate;
    private List<Medication> medications;
    private List<Procedure> procedures;
    private List<DiagnosticAid> diagnosticAids;

    public static ClinicalOrderBuilder builder() {
        return new ClinicalOrderBuilder();
    }

    public ClinicalOrderBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public ClinicalOrderBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public ClinicalOrderBuilder withDoctor(User doctor) {
        this.doctor = doctor;
        return this;
    }

    public ClinicalOrderBuilder withCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public ClinicalOrderBuilder withMedications(List<Medication> medications) {
        this.medications = medications;
        return this;
    }

    public ClinicalOrderBuilder withProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
        return this;
    }

    public ClinicalOrderBuilder withDiagnosticAids(List<DiagnosticAid> diagnosticAids) {
        this.diagnosticAids = diagnosticAids;
        return this;
    }

    public ClinicalOrder build() {
        ClinicalOrder clinicalOrder = new ClinicalOrder();
        clinicalOrder.setId(id);
        clinicalOrder.setPatient(patient);
        clinicalOrder.setDoctor(doctor);
        clinicalOrder.setCreationDate(creationDate);
        clinicalOrder.setMedications(medications);
        clinicalOrder.setProcedures(procedures);
        clinicalOrder.setDiagnosticAids(diagnosticAids);
        return clinicalOrder;
    }
}