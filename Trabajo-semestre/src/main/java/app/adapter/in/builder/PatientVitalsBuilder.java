package app.adapter.in.builder;

import app.adapter.in.validators.PatientVitalsValidator;
import app.adapter.in.validators.PatientValidator;
import app.domain.model.Patient;
import app.domain.model.PatientVitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class PatientVitalsBuilder {

    @Autowired
    private PatientVitalsValidator vitalsValidator;
    @Autowired
    private PatientValidator patientValidator;

    public PatientVitals build(String patientId, String bloodPressure, String temperature, String pulse, String oxygenLevel) throws Exception {
        
        Patient patient = new Patient();
        patient.setIdentificationNumber(patientValidator.documentValidator(patientId));

        PatientVitals vitals = new PatientVitals();
        vitals.setPatient(patient);
        vitals.setBloodPressure(vitalsValidator.stringValidator(bloodPressure));
        vitals.setTemperature(vitalsValidator.doubleValidator(temperature));
        vitals.setPulse(vitalsValidator.integerValidator(pulse));
        vitals.setOxygenLevel(vitalsValidator.doubleValidator(oxygenLevel));
        vitals.setRecordTimestamp(LocalDateTime.now());
        
        return vitals;
    }
}