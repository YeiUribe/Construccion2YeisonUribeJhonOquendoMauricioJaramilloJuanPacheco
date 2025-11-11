package app.infrastructure.persistence.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate issueDate;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;
    
    private double totalAmount;
    private double copayAmount;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }
    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public double getCopayAmount() { return copayAmount; }
    public void setCopayAmount(double copayAmount) { this.copayAmount = copayAmount; }
}