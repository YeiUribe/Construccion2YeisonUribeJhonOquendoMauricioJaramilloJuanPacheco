package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {

    void save(Patient patient) throws Exception;

    Patient findByIdentificationNumber(String identificationNumber) throws Exception;
}
