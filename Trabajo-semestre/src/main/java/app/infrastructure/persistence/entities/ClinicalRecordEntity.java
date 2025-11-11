package app.infrastructure.persistence.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "clinical_records")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;
    
    private LocalDate recordDate;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "vitals_id")
    private PatientVitalsEntity vitals; 
    
    private String reasonForVisit;
    private String symptoms;
    private String diagnosis;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private ClinicalOrderEntity clinicalOrder;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }
    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }
    public LocalDate getRecordDate() { return recordDate; }
    public void setRecordDate(LocalDate recordDate) { this.recordDate = recordDate; }
    public PatientVitalsEntity getVitals() { return vitals; }
    public void setVitals(PatientVitalsEntity vitals) { this.vitals = vitals; }
    public String getReasonForVisit() { return reasonForVisit; }
    public void setReasonForVisit(String reasonForVisit) { this.reasonForVisit = reasonForVisit; }
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public ClinicalOrderEntity getClinicalOrder() { return clinicalOrder; }
    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) { this.clinicalOrder = clinicalOrder; }
}