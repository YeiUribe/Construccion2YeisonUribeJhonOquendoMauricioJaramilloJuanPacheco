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
@Table(name = "insurance")
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private long insuranceId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @Column(name = "nombre_compania", nullable = false, length = 100)
    private String nombreCompania;

    @Column(name = "numero_poliza", nullable = false, unique = true, length = 30)
    private String numeroPoliza;

    @Column(name = "estado_poliza", nullable = false)
    private boolean estadoPoliza;

    @Column(name = "vigencia", nullable = false, length = 20)
    private String vigencia; 

    
    public InsuranceEntity() {
    }

    public InsuranceEntity(long insuranceId, PatientEntity patient, String nombreCompania,
                           String numeroPoliza, boolean estadoPoliza, String vigencia) {
        this.insuranceId = insuranceId;
        this.patient = patient;
        this.nombreCompania = nombreCompania;
        this.numeroPoliza = numeroPoliza;
        this.estadoPoliza = estadoPoliza;
        this.vigencia = vigencia;
    }

    // --- Getters y Setters ---
    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public boolean isEstadoPoliza() {
        return estadoPoliza;
    }

    public void setEstadoPoliza(boolean estadoPoliza) {
        this.estadoPoliza = estadoPoliza;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
}

