package app.adapter.in.builder;

import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class ClinicalOrderBuilder {

    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private UserValidator userValidator;

    public ClinicalOrder build(String patientId, String doctorId) throws Exception {

        Patient patient = new Patient();
        patient.setIdentificationNumber(patientValidator.documentValidator(patientId));

        User doctor = new User();
        doctor.setDocumentNumber(userValidator.documentValidator(doctorId));

        ClinicalOrder order = new ClinicalOrder();
        order.setPatient(patient);
        order.setDoctor(doctor);
        order.setCreationDate(LocalDate.now());

        order.setMedications(new ArrayList<>());
        order.setProcedures(new ArrayList<>());
        order.setDiagnosticAids(new ArrayList<>());

        return order;
    }
}
