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

    public Patient registerNewPatient(Patient patient) throws Exception {
        return registerPatient.execute(patient);
    }

    public Invoice generateInvoice(Invoice invoice) throws Exception {
        
        LocalDate issueDate = invoice.getIssueDate();
        int year = issueDate.getYear();

        boolean isExempt = checkCopayExemption.isExempt(invoice.getPatient(), year);

        if (isExempt) {
            invoice.setCopayAmount(0);
        } else if (invoice.getPatient().getInsurance() != null &&
                   invoice.getPatient().getInsurance().isActive()) {
            double copay = calculateActivePolicyCopay.execute();
            invoice.setCopayAmount(copay);
        } else {
            double copay = calculateInactivePolicyPayment.execute(
                invoice.getTotalAmount()
            );
            invoice.setCopayAmount(copay);
        }

        return invoice;
    }
}

