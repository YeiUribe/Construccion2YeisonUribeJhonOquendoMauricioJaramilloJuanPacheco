package app.domain.ports;

import app.domain.model.PatientVitals;

public interface PatientVitalsPort {
    PatientVitals save(PatientVitals vitals);
}