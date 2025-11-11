package app.infrastructure.persistence.entities;

import app.domain.model.enums.Specialty;
import jakarta.persistence.*;

@Entity
@Table(name = "medications")
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int itemNumber;
    private String name;
    private String dosage;
    private String duration;
    private double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private ClinicalOrderEntity clinicalOrder;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int itemNumber) { this.itemNumber = itemNumber; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public ClinicalOrderEntity getClinicalOrder() { return clinicalOrder; }
    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) { this.clinicalOrder = clinicalOrder; }
}