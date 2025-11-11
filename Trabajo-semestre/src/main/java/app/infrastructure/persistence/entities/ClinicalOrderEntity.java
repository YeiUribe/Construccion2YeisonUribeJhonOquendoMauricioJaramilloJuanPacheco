package app.infrastructure.persistence.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "clinical_orders")
public class ClinicalOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;
    
    private LocalDate creationDate;
    
    @OneToMany(mappedBy = "clinicalOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicationEntity> medications;
    
    @OneToMany(mappedBy = "clinicalOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProcedureEntity> procedures;
    
    @OneToMany(mappedBy = "clinicalOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DiagnosticAidEntity> diagnosticAids;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }
    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }
    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }
    public List<MedicationEntity> getMedications() { return medications; }
    public void setMedications(List<MedicationEntity> medications) { this.medications = medications; }
    public List<ProcedureEntity> getProcedures() { return procedures; }
    public void setProcedures(List<ProcedureEntity> procedures) { this.procedures = procedures; }
    public List<DiagnosticAidEntity> getDiagnosticAids() { return diagnosticAids; }
    public void setDiagnosticAids(List<DiagnosticAidEntity> diagnosticAids) { this.diagnosticAids = diagnosticAids; }
}