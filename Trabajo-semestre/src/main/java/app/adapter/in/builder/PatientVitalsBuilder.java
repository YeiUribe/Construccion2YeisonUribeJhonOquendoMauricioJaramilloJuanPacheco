package app.adapter.in.builder;

import app.domain.model.PatientVitals;
import app.domain.model.Patient;
import java.time.LocalDateTime;

public class PatientVitalsBuilder {
    private Patient patient;
    private LocalDateTime recordTimestamp;
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private double oxygenLevel;

    public static PatientVitalsBuilder builder() {
        return new PatientVitalsBuilder();
    }

    public PatientVitalsBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public PatientVitalsBuilder withRecordTimestamp(LocalDateTime recordTimestamp) {
        this.recordTimestamp = recordTimestamp;
        return this;
    }

    public PatientVitalsBuilder withBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
        return this;
    }

    public PatientVitalsBuilder withTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }

    public PatientVitalsBuilder withPulse(int pulse) {
        this.pulse = pulse;
        return this;
    }

    public PatientVitalsBuilder withOxygenLevel(double oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
        return this;
    }

    public PatientVitals build() {
        PatientVitals patientVitals = new PatientVitals();
        patientVitals.setPatient(patient);
        patientVitals.setRecordTimestamp(recordTimestamp);
        patientVitals.setBloodPressure(bloodPressure);
        patientVitals.setTemperature(temperature);
        patientVitals.setPulse(pulse);
        patientVitals.setOxygenLevel(oxygenLevel);
        return patientVitals;
    }
}