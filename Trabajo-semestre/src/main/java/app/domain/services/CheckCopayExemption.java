package app.domain.services;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.ports.InvoicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckCopayExemption {

    @Autowired
    private InvoicePort invoicePort;

    public boolean isExempt(Patient patient, int year) {
        List<Invoice> pastInvoices = invoicePort.findByPatient(patient);
        double yearlyCopayTotal = pastInvoices.stream()
                .filter(inv -> inv.getIssueDate().getYear() == year)
                .mapToDouble(Invoice::getCopayAmount)
                .sum();

        return yearlyCopayTotal >= 1000000;
    }
}
