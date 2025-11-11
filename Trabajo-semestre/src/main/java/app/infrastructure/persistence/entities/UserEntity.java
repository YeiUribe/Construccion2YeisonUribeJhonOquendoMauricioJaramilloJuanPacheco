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
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private long userId;

    @Column(name = "Nombre_completo", nullable = false, length = 100)
    private String fullName;

    @Column(name = "Cedula", nullable = false, unique = true, length = 10)
    private String documentNumber;

    @Column(name = "Correo", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "Telefono", nullable = false, length = 10)
    private String phoneNumber;

    @Column(name = "Fecha_nacimiento", nullable = false, length = 20)
    private String birthDate;

    @Column(name = "Direccion", nullable = false, length = 100)
    private String adress;

    @Enumerated(EnumType.STRING)
    @Column(name = "Rol", nullable = false, length = 30)
    private Rol role;

    public enum Rol {
        HUMAN_RESOURCES,
        ADMINISTRATIVE_STAFF,
        INFORMATION_SUPPORT,
        NURSE,
        DOCTOR
    }

    public UserEntity() {
    }

    public UserEntity(long userId, String fullName, String documentNumber, String email, String phoneNumber, String birthDate, String adress, Rol role) {
        this.userId = userId;
        this.fullName = fullName;
        this.documentNumber = documentNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.adress = adress;
        this.role = role;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Rol getRole() {
        return role;
    }

    public void setRole(Rol role) {
        this.role = role;
    }

}
