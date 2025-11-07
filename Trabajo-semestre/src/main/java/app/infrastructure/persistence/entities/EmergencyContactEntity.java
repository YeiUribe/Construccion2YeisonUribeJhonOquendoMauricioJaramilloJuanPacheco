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
@Table(name = "emergency_contact")
public class EmergencyContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long contactId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;

    @Column(name = "relacion", nullable = false, length = 50)
    private String relacion;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

   
    public EmergencyContactEntity() {
    }

    public EmergencyContactEntity(long contactId, PatientEntity patient, String nombres,
                                  String apellidos, String relacion, String telefono) {
        this.contactId = contactId;
        this.patient = patient;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.relacion = relacion;
        this.telefono = telefono;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

