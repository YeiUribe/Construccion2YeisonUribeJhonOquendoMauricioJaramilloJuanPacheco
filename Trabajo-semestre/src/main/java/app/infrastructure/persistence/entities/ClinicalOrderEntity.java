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
@Table(name = "clinical_order")
public class ClinicalOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @Column(name = "fecha_creacion", nullable = false, length = 20)
    private String fechaCreacion; 

    @Column(name = "tipo_orden", nullable = false, length = 50)
    private String tipoOrden; 

    @Column(name = "activo", nullable = false)
    private boolean activo;

  
    public ClinicalOrderEntity() {
    }

    public ClinicalOrderEntity(long orderId, PatientEntity patient, UserEntity doctor,
                               String fechaCreacion, String tipoOrden, boolean activo) {
        this.orderId = orderId;
        this.patient = patient;
        this.doctor = doctor;
        this.fechaCreacion = fechaCreacion;
        this.tipoOrden = tipoOrden;
        this.activo = activo;
    }

    
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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

    public String getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
