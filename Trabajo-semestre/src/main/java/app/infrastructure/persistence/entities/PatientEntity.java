package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long patientId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "tipo_sangre", length = 5)
    private String tipoSangre;

    @Column(name = "alergias", columnDefinition = "TEXT")
    private String alergias;

    @Column(name = "antecedentes_medicos", columnDefinition = "TEXT")
    private String antecedentesMedicos;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "telefono_contacto", length = 20)
    private String telefonoContacto;

    @Column(name = "direccion_contacto", length = 150)
    private String direccionContacto;

    @Column(name = "estado", nullable = false)
    private boolean estado; 
    
    public PatientEntity() {
    }

    public PatientEntity(long patientId, UserEntity user, String tipoSangre, String alergias,
                         String antecedentesMedicos, double peso, double altura,
                         String telefonoContacto, String direccionContacto, boolean estado) {
        this.patientId = patientId;
        this.user = user;
        this.tipoSangre = tipoSangre;
        this.alergias = alergias;
        this.antecedentesMedicos = antecedentesMedicos;
        this.peso = peso;
        this.altura = altura;
        this.telefonoContacto = telefonoContacto;
        this.direccionContacto = direccionContacto;
        this.estado = estado;
    }

    
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getAntecedentesMedicos() {
        return antecedentesMedicos;
    }

    public void setAntecedentesMedicos(String antecedentesMedicos) {
        this.antecedentesMedicos = antecedentesMedicos;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
