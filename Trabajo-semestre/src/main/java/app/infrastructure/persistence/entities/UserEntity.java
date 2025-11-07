package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "cedula", nullable = false, unique = true, length = 10)
    private String cedula;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "fecha_nacimiento", nullable = false, length = 20)
    private String fechaNacimiento;

    @Column(name = "direccion", nullable = false, length = 100)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column(name = "rol", nullable = false, length = 30)
    private Rol rol;

    
    public enum Rol {
        RECURSOS_HUMANOS,
        ADMINISTRATIVO,
        SOPORTE_INFORMACION,
        ENFERMERA,
        MEDICO
    }

   
    public UserEntity() {
    }

    public UserEntity(long userId, String nombreCompleto, String cedula, String correo,
                      String telefono, String fechaNacimiento, String direccion, Rol rol) {
        this.userId = userId;
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.rol = rol;
    }

  
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
