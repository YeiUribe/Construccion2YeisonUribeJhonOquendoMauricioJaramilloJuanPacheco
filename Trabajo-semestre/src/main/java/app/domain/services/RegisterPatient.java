package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPatient {

    @Autowired
    private PatientPort patientPort;

    public Patient execute(Patient patient) throws Exception {
        if (patientPort.findByIdentificationNumber(patient.getIdentificationNumber()) != null) {
            throw new IllegalStateException("El paciente con este número de identificación ya existe.");
        }
        patientPort.save(patient);
        return patient;
    }
}
