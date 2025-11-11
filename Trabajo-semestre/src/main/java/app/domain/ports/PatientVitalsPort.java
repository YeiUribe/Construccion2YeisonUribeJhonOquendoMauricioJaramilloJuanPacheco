package app.domain.ports;

import java.util.List;

import app.domain.model.PatientVitals;

public interface PatientVitalsPort {
    void save(PatientVitals vitals) throws Exception;
    List<PatientVitals> findByPatient(PatientVitals vitals) throws Exception;
    List<PatientVitals> findByTimestamp(PatientVitals vitals) throws Exception;
}