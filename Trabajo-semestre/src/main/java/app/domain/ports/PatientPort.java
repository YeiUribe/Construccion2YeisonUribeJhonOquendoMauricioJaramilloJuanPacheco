package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {

    void save(Patient patient);

    Patient findByIdentificationNumber(String identificationNumber);
}
