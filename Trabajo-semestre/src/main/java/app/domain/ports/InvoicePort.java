package app.domain.ports;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import java.util.List;

public interface InvoicePort {

    void save(Invoice invoice) throws Exception;

    Invoice findById(long id) throws Exception;

    List<Invoice> findByPatient(Patient patient) throws Exception;
}
