package app.application.usecases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.CalculateActivePolicyCopay;
import app.domain.services.CalculateInactivePolicyPayment;
import app.domain.services.CheckCopayExemption;
import app.domain.services.RegisterPatient;

@Component
public class AdministrativeUseCase {

    @Autowired
    private RegisterPatient registerPatient;

    @Autowired
    private CheckCopayExemption checkCopayExemption;

    @Autowired
    private CalculateActivePolicyCopay calculateActivePolicyCopay;

    @Autowired
    private CalculateInactivePolicyPayment calculateInactivePolicyPayment;

    public Patient registerNewPatient(Patient patient) {
        return registerPatient.execute(patient);
    }

    public Invoice generateInvoice(Invoice invoice) {
        
        LocalDate issueDate = LocalDate.parse(invoice.getIssueDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        int year = issueDate.getYear();

        boolean isExempt = checkCopayExemption.isExempt(invoice.getPatient(), year);

        if (isExempt) {
            invoice.setCopayAmount("0");
        } else if (invoice.getPatient().getInsurance() != null &&
                   invoice.getPatient().getInsurance().isActive()) {
            double copay = calculateActivePolicyCopay.execute();
            invoice.setCopayAmount(String.valueOf(copay));
        } else {
            double copay = calculateInactivePolicyPayment.execute(
                Double.parseDouble(invoice.getTotalAmount())
            );
            invoice.setCopayAmount(String.valueOf(copay));
        }

        return invoice;
    }
}

