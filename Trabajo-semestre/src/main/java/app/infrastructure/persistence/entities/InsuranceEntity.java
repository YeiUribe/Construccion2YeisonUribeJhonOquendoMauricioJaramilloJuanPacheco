package app.infrastructure.persistence.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "insurances")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String companyName;

    private String contactNumber;
    private boolean active;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}