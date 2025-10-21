package app.application.usecases;

import app.domain.services.CalculateActivePolicyCopay;
import app.domain.services.CalculateInactivePolicyPayment;
import app.domain.services.CheckCopayExemption;
import app.domain.services.RegisterPatient;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        boolean isExempt = checkCopayExemption.isExempt(invoice.getPatient(), invoice.getIssueDate().getYear());
        
        if (isExempt) {
            invoice.setCopayAmount(0);
        } else if (invoice.getPatient().getInsurance() != null && invoice.getPatient().getInsurance().isActive()) {
            invoice.setCopayAmount(calculateActivePolicyCopay.execute());
        } else {
            invoice.setCopayAmount(calculateInactivePolicyPayment.execute(invoice.getTotalAmount()));
        }
        
        return invoice; 
    }
}
