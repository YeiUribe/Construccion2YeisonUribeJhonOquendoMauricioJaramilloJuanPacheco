package app.adapter.in.builder;

import app.adapter.in.validators.InvoiceValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class InvoiceBuilder {

    @Autowired
    private InvoiceValidator invoiceValidator;
    @Autowired
    private PatientValidator patientValidator;
    @Autowired
    private UserValidator userValidator;

    public Invoice build(String patientId, String doctorId) throws Exception {

        Patient patient = new Patient();
        patient.setIdentificationNumber(patientValidator.documentValidator(patientId));

        User doctor = new User();
        doctor.setDocumentNumber(userValidator.documentValidator(doctorId));

        Invoice invoice = new Invoice();
        invoice.setPatient(patient);
        invoice.setDoctor(doctor);

        LocalDate today = LocalDate.now();

        //String dateAsString = today.format(DateTimeFormatter.ISO_LOCAL_DATE);

        invoice.setIssueDate(today);

        return invoice;
    }
}
