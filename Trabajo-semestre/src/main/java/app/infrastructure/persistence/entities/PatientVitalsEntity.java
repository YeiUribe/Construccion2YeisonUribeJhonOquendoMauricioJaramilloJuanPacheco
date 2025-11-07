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
@Table(name = "patient_vitals")
public class PatientVitalsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vital_id")
    private long vitalId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @Column(name = "fecha_registro", nullable = false, length = 20)
    private String fechaRegistro; 

    @Column(name = "presion_arterial", length = 20)
    private String presionArterial; 

    @Column(name = "frecuencia_cardiaca")
    private int frecuenciaCardiaca; 

    @Column(name = "frecuencia_respiratoria")
    private int frecuenciaRespiratoria; 

    @Column(name = "temperatura_corporal")
    private double temperaturaCorporal; 

    @Column(name = "saturacion_oxigeno")
    private int saturacionOxigeno; 

    @Column(name = "peso")
    private double peso; 

    @Column(name = "altura")
    private double altura; 

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    
    public PatientVitalsEntity() {
    }

    public PatientVitalsEntity(long vitalId, PatientEntity patient, String fechaRegistro,
                               String presionArterial, int frecuenciaCardiaca,
                               int frecuenciaRespiratoria, double temperaturaCorporal,
                               int saturacionOxigeno, double peso, double altura, String observaciones) {
        this.vitalId = vitalId;
        this.patient = patient;
        this.fechaRegistro = fechaRegistro;
        this.presionArterial = presionArterial;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperaturaCorporal = temperaturaCorporal;
        this.saturacionOxigeno = saturacionOxigeno;
        this.peso = peso;
        this.altura = altura;
        this.observaciones = observaciones;
    }

    // --- Getters y Setters ---
    public long getVitalId() {
        return vitalId;
    }

    public void setVitalId(long vitalId) {
        this.vitalId = vitalId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getPresionArterial() {
        return presionArterial;
    }

    public void setPresionArterial(String presionArterial) {
        this.presionArterial = presionArterial;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public int getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public double getTemperaturaCorporal() {
        return temperaturaCorporal;
    }

    public void setTemperaturaCorporal(double temperaturaCorporal) {
        this.temperaturaCorporal = temperaturaCorporal;
    }

    public int getSaturacionOxigeno() {
        return saturacionOxigeno;
    }

    public void setSaturacionOxigeno(int saturacionOxigeno) {
        this.saturacionOxigeno = saturacionOxigeno;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
