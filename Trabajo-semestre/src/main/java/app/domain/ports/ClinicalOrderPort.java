package app.domain.ports;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import java.util.List;

public interface ClinicalOrderPort {

    void save(ClinicalOrder order) throws Exception;

    ClinicalOrder findById(long id) throws Exception;

    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;
}
