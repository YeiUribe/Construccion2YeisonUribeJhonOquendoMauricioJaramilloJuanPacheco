package app.domain.services;

import app.domain.model.PatientVitals;
import app.domain.ports.PatientVitalsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordVitals {

    @Autowired
    private PatientVitalsPort patientVitalsPort;

    public PatientVitals execute(PatientVitals vitals) throws Exception {
        System.out.println("Guardando signos vitales del paciente: " + vitals.getPatient().getFullName());
        return patientVitalsPort.save(vitals);
    }
}
