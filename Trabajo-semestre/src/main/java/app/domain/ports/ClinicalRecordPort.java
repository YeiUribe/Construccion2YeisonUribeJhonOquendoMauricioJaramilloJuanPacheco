package app.domain.ports;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import java.util.List;

public interface ClinicalRecordPort {

    ClinicalRecord save(ClinicalRecord record);

    List<ClinicalRecord> findByPatient(Patient patient);
}
