package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Diagnostic_aid")
public class DiagnosticAidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Diagnostic_aid_id")
    private long diagnosticAidId;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String name;

    @Column(name = "Descripcion", length = 255)
    private String description;

    @Column(name = "Costo", nullable = false)
    private double cost;

    @Column(name = "Requiere_especialista", nullable = false)
    private boolean requiresSpecialist;

    @Column(name = "Tipo_especialidad", length = 100)
    private String specialtyType;

    @Column(name = "Estado", nullable = false)
    private boolean status;

    public DiagnosticAidEntity() {
    }

    public DiagnosticAidEntity(long diagnosticAidId, String name, String description,
            double cost, boolean requiresSpecialist,
            String specialtyType, boolean status) {
        this.diagnosticAidId = diagnosticAidId;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
        this.specialtyType = specialtyType;
        this.status = status;
    }

    public long getDiagnosticAidId() {
        return diagnosticAidId;
    }

    public void setDiagnosticAidId(long diagnosticAidId) {
        this.diagnosticAidId = diagnosticAidId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialtyType() {
        return specialtyType;
    }

    public void setSpecialtyType(String specialtyType) {
        this.specialtyType = specialtyType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
