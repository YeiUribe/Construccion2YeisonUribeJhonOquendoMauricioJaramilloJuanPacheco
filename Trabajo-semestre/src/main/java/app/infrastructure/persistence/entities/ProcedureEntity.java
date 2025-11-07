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
@Table(name = "procedure")
public class ProcedureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_id")
    private long procedureId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private ClinicalOrderEntity clinicalOrder;

    @Column(name = "item_number", nullable = false)
    private int itemNumber;

    @Column(name = "procedure_name", nullable = false, length = 100)
    private String procedureName;

    @Column(name = "repetitions", nullable = false)
    private int repetitions;

    @Column(name = "frequency", nullable = false, length = 50)
    private String frequency;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "requires_specialist", nullable = false)
    private boolean requiresSpecialist;

    @Column(name = "specialist_type_id")
    private Long specialistTypeId; 


    public ProcedureEntity() {
    }

    public ProcedureEntity(long procedureId, ClinicalOrderEntity clinicalOrder, int itemNumber,
                           String procedureName, int repetitions, String frequency,
                           double cost, boolean requiresSpecialist, Long specialistTypeId) {
        this.procedureId = procedureId;
        this.clinicalOrder = clinicalOrder;
        this.itemNumber = itemNumber;
        this.procedureName = procedureName;
        this.repetitions = repetitions;
        this.frequency = frequency;
        this.cost = cost;
        this.requiresSpecialist = requiresSpecialist;
        this.specialistTypeId = specialistTypeId;
    }

    // --- Getters y Setters ---
    public long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(long procedureId) {
        this.procedureId = procedureId;
    }

    public ClinicalOrderEntity getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
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

    public Long getSpecialistTypeId() {
        return specialistTypeId;
    }

    public void setSpecialistTypeId(Long specialistTypeId) {
        this.specialistTypeId = specialistTypeId;
    }
}