package app.infrastructure.persistence.entities;
import app.domain.model.enums.Specialty;
import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_aids")
public class DiagnosticAidEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int itemNumber;
    private String name;
    private int quantity;
    private boolean requiresSpecialist;
    
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    
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
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(boolean requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }
    public Specialty getSpecialty() { return specialty; }
    public void setSpecialty(Specialty specialty) { this.specialty = specialty; }
    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
    public ClinicalOrderEntity getClinicalOrder() { return clinicalOrder; }
    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) { this.clinicalOrder = clinicalOrder; }
}