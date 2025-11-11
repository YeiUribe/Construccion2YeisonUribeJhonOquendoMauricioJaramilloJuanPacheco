package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Medication")
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Medication_id")
    private long medicationId;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String name;

    @Column(name = "Descripcion", columnDefinition = "TEXT")
    private String description;

    @Column(name = "Forma_farmaceutica", length = 50)
    private String pharmaceuticalForm;

    @Column(name = "Dosis", length = 50)
    private String dosage;

    @Column(name = "Via_administracion", length = 50)
    private String administrationRoute;

    @Column(name = "Fabricante", length = 100)
    private String manufacturer;

    @Column(name = "Stock_disponible", nullable = false)
    private int availableStock;

    @Column(name = "Precio_unitario", nullable = false)
    private double unitPrice;

    public MedicationEntity() {
    }

    public MedicationEntity(long medicationId, String name, String description, String pharmaceuticalForm,
            String dosage, String administrationRoute, String manufacturer,
            int availableStock, double unitPrice) {
        this.medicationId = medicationId;
        this.name = name;
        this.description = description;
        this.pharmaceuticalForm = pharmaceuticalForm;
        this.dosage = dosage;
        this.administrationRoute = administrationRoute;
        this.manufacturer = manufacturer;
        this.availableStock = availableStock;
        this.unitPrice = unitPrice;
    }

    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(long medicationId) {
        this.medicationId = medicationId;
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

    public String getPharmaceuticalForm() {
        return pharmaceuticalForm;
    }

    public void setPharmaceuticalForm(String pharmaceuticalForm) {
        this.pharmaceuticalForm = pharmaceuticalForm;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getAdministrationRoute() {
        return administrationRoute;
    }

    public void setAdministrationRoute(String administrationRoute) {
        this.administrationRoute = administrationRoute;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}