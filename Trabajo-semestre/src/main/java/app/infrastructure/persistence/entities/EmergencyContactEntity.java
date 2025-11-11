package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Emergency_contact")
public class EmergencyContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Contact_id")
    private long contactId;

    @ManyToOne
    @JoinColumn(name = "Patient_id", nullable = false)
    private PatientEntity patient;

    @Column(name = "Nombres", nullable = false, length = 50)
    private String firstName;

    @Column(name = "Apellidos", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Relacion", nullable = false, length = 50)
    private String relationship;

    @Column(name = "Telefono", nullable = false, length = 10)
    private String phone;

    public EmergencyContactEntity() {
    }

    public EmergencyContactEntity(long contactId, PatientEntity patient, String firstName,
            String lastName, String relationship, String phone) {
        this.contactId = contactId;
        this.patient = patient;
        this.firstName = firstName;
        this.lastName = lastName;
        this.relationship = relationship;
        this.phone = phone;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}