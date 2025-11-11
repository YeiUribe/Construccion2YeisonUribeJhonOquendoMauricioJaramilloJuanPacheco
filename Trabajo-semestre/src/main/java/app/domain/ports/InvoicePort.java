package app.domain.ports;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import java.util.List;

public interface InvoicePort {

    void save(Invoice invoice);

    Invoice findById(long id);

    List<Invoice> findByPatient(Patient patient);
}
