package app.infrastructure.persistence.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_vitals")
public class PatientVitalsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient; 
    
    private LocalDateTime recordTimestamp;
    private String bloodPressure;
    private double temperature;
    private int pulse;
    private double oxygenLevel;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }
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