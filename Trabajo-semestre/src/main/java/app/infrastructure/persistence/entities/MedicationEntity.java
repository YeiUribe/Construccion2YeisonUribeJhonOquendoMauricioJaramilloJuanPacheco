
package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medication")
public class MedicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private long medicationId;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "forma_farmaceutica", length = 50)
    private String formaFarmaceutica; 

    @Column(name = "dosis", length = 50)
    private String dosis; 

    @Column(name = "via_administracion", length = 50)
    private String viaAdministracion; 

    @Column(name = "fabricante", length = 100)
    private String fabricante;

    @Column(name = "stock_disponible", nullable = false)
    private int stockDisponible;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

  
    public MedicationEntity() {
    }

    public MedicationEntity(long medicationId, String nombre, String descripcion, String formaFarmaceutica,
                            String dosis, String viaAdministracion, String fabricante,
                            int stockDisponible, double precioUnitario) {
        this.medicationId = medicationId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.formaFarmaceutica = formaFarmaceutica;
        this.dosis = dosis;
        this.viaAdministracion = viaAdministracion;
        this.fabricante = fabricante;
        this.stockDisponible = stockDisponible;
        this.precioUnitario = precioUnitario;
    }

    
    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(long medicationId) {
        this.medicationId = medicationId;
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

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getStockDisponible() {
        return stockDisponible;
    }

    public void setStockDisponible(int stockDisponible) {
        this.stockDisponible = stockDisponible;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}

