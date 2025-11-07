package app.adapter.in.builder;

import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.adapter.in.validators.ClinicalRecordValidator;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class ClinicalRecordBuilder {

    @Autowired
    private ClinicalRecordValidator clinicalRecordValidator;
    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private UserValidator userValidator;

    public ClinicalRecord build(String patientId, String doctorId, String reasonForVisit, String symptoms, String diagnosis) throws Exception {
        
        Patient patient = new Patient();
        patient.setIdentificationNumber(patientValidator.documentValidator(patientId));

        User doctor = new User();
        doctor.setDocumentNumber(userValidator.documentValidator(doctorId));
        
        ClinicalRecord record = new ClinicalRecord();
        record.setPatient(patient);
        record.setDoctor(doctor);
        record.setRecordDate(LocalDate.now());
        record.setReasonForVisit(clinicalRecordValidator.stringValidator("Motivo de Visita", reasonForVisit));
        record.setSymptoms(clinicalRecordValidator.stringValidator("Síntomas", symptoms));
        record.setDiagnosis(clinicalRecordValidator.stringValidator("Diagnóstico", diagnosis));

        return record;
    }
}