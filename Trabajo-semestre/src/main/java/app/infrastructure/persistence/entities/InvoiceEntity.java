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
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long invoiceId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private InsuranceEntity insurance;

    @Column(name = "numero_poliza", length = 30)
    private String numeroPoliza;

    @Column(name = "dias_vigencia", nullable = false)
    private int diasVigencia;

    @Column(name = "fecha_finalizacion", nullable = false, length = 20)
    private String fechaFinalizacion; 

    @Column(name = "costo_total", nullable = false)
    private double costoTotal;

    @Column(name = "copago", nullable = false)
    private double copago;

    @Column(name = "detalle", columnDefinition = "TEXT")
    private String detalle; 

  
    public InvoiceEntity() {
    }

    public InvoiceEntity(long invoiceId, PatientEntity patient, UserEntity doctor,
                         InsuranceEntity insurance, String numeroPoliza,
                         int diasVigencia, String fechaFinalizacion,
                         double costoTotal, double copago, String detalle) {
        this.invoiceId = invoiceId;
        this.patient = patient;
        this.doctor = doctor;
        this.insurance = insurance;
        this.numeroPoliza = numeroPoliza;
        this.diasVigencia = diasVigencia;
        this.fechaFinalizacion = fechaFinalizacion;
        this.costoTotal = costoTotal;
        this.copago = copago;
        this.detalle = detalle;
    }

   
    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
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

    public InsuranceEntity getInsurance() {
        return insurance;
    }

    public void setInsurance(InsuranceEntity insurance) {
        this.insurance = insurance;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }

    public String getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(String fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double getCopago() {
        return copago;
    }

    public void setCopago(double copago) {
        this.copago = copago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
