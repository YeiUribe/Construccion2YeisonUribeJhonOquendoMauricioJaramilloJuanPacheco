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
@Table(name = "Clinical_order")
public class ClinicalOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_id")
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "Patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "Doctor_id", nullable = false)
    private UserEntity doctor;

    @Column(name = "Fecha_creacion", nullable = false, length = 20)
    private String creationDate;

    @Column(name = "Tipo_orden", nullable = false, length = 50)
    private String orderType;

    @Column(name = "Activo", nullable = false)
    private boolean isActive;

    public ClinicalOrderEntity() {
    }

    public ClinicalOrderEntity(long orderId, PatientEntity patient, UserEntity doctor,
            String creationDate, String orderType, boolean isActive) {
        this.orderId = orderId;
        this.patient = patient;
        this.doctor = doctor;
        this.creationDate = creationDate;
        this.orderType = orderType;
        this.isActive = isActive;
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
