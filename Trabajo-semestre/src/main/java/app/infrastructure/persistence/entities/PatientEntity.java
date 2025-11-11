package app.infrastructure.persistence.entities;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    @Column(length = 20)
    private String identificationNumber; // Cédula como PK

    @Column(nullable = false)
    private String fullName;
    
    private LocalDate birthDate;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    
    @Embedded
    private EmergencyContactEmbeddable emergencyContact;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    private InsuranceEntity insurance;

    // Getters y Setters
    public String getIdentificationNumber() { return identificationNumber; }
    public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public EmergencyContactEmbeddable getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(EmergencyContactEmbeddable emergencyContact) { this.emergencyContact = emergencyContact; }
    public InsuranceEntity getInsurance() { return insurance; }
    public void setInsurance(InsuranceEntity insurance) { this.insurance = insurance; }
}