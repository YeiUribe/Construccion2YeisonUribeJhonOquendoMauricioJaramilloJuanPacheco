package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostic_aid")
public class DiagnosticAidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnostic_aid_id")
    private long diagnosticAidId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Column(name = "costo", nullable = false)
    private double costo;

    @Column(name = "requiere_especialista", nullable = false)
    private boolean requiereEspecialista;

    @Column(name = "tipo_especialidad", length = 100)
    private String tipoEspecialidad;

    @Column(name = "estado", nullable = false)
    private boolean estado;

   
    public DiagnosticAidEntity() {
    }

    public DiagnosticAidEntity(long diagnosticAidId, String nombre, String descripcion,
                               double costo, boolean requiereEspecialista,
                               String tipoEspecialidad, boolean estado) {
        this.diagnosticAidId = diagnosticAidId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.requiereEspecialista = requiereEspecialista;
        this.tipoEspecialidad = tipoEspecialidad;
        this.estado = estado;
    }

   
    public long getDiagnosticAidId() {
        return diagnosticAidId;
    }

    public void setDiagnosticAidId(long diagnosticAidId) {
        this.diagnosticAidId = diagnosticAidId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isRequiereEspecialista() {
        return requiereEspecialista;
    }

    public void setRequiereEspecialista(boolean requiereEspecialista) {
        this.requiereEspecialista = requiereEspecialista;
    }

    public String getTipoEspecialidad() {
        return tipoEspecialidad;
    }

    public void setTipoEspecialidad(String tipoEspecialidad) {
        this.tipoEspecialidad = tipoEspecialidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
