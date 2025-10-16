package app.domain.ports;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import java.util.List;

public interface ClinicalOrderPort {

    ClinicalOrder save(ClinicalOrder order);

    ClinicalOrder findById(long id);

    List<ClinicalOrder> findByPatient(Patient patient);
}
