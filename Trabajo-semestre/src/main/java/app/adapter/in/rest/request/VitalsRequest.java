package app.adapter.in.rest.request;

public class VitalsRequest {
    private String patientId;
    private String bloodPressure;
    private String temperature;
    private String pulse;
    private String oxygenLevel;

    // Getters y Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }
    public String getPulse() { return pulse; }
    public void setPulse(String pulse) { this.pulse = pulse; }
    public String getOxygenLevel() { return oxygenLevel; }
    public void setOxygenLevel(String oxygenLevel) { this.oxygenLevel = oxygenLevel; }
}
