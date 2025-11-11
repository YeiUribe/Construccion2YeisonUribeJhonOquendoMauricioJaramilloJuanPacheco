package app.domain.ports;

import app.domain.model.PatientVitals;

public interface PatientVitalsPort {
    void save(PatientVitals vitals) throws Exception;
    PatientVitals findByPatient(PatientVitals vitals) throws Exception;
    PatientVitals findByTimestamp(PatientVitals vitals) throws Exception;
}