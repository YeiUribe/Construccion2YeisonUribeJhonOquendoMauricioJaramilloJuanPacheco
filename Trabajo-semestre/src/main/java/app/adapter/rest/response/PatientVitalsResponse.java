package app.adapter.rest.response;

import java.time.LocalDateTime;

public class PatientVitalsResponse {
    private long id;
    private String patientId;
    private LocalDateTime recordTimestamp;
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private double oxygenLevel;

    public PatientVitalsResponse() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public LocalDateTime getRecordTimestamp() { return recordTimestamp; }
    public void setRecordTimestamp(LocalDateTime recordTimestamp) { this.recordTimestamp = recordTimestamp; }

    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getPulse() { return pulse; }
    public void setPulse(int pulse) { this.pulse = pulse; }

    public double getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(double oxygenLevel) { this.oxygenLevel = oxygenLevel; }
}
