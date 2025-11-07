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
@Table(name = "clinical_record")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinical_record_id")
    private long clinicalRecordId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @Column(name = "fecha_creacion", nullable = false, length = 20)
    private String fechaCreacion; // formato DD/MM/YYYY

    @Column(name = "diagnostico", nullable = false, length = 500)
    private String diagnostico;

    @Column(name = "tratamiento", nullable = false, length = 500)
    private String tratamiento;

    @Column(name = "observaciones", length = 500)
    private String observaciones;

    @Column(name = "activo", nullable = false)
    private boolean activo;

    
    public ClinicalRecordEntity() {
    }

    public ClinicalRecordEntity(long clinicalRecordId, PatientEntity patient, UserEntity doctor,
                                String fechaCreacion, String diagnostico, String tratamiento,
                                String observaciones, boolean activo) {
        this.clinicalRecordId = clinicalRecordId;
        this.patient = patient;
        this.doctor = doctor;
        this.fechaCreacion = fechaCreacion;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
        this.activo = activo;
    }

    
    public long getClinicalRecordId() {
        return clinicalRecordId;
    }

    public void setClinicalRecordId(long clinicalRecordId) {
        this.clinicalRecordId = clinicalRecordId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public UserEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(UserEntity doctor) {
        this.doctor = doctor;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

