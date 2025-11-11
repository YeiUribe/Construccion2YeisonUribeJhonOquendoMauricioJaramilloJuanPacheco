package app.infrastructure.persistence.entities;

import app.domain.model.enums.Role;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @Column(length = 20)
    private String documentNumber; // Cédula como PK

    @Column(nullable = false)
    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 10)
    private String phoneNumber;

    private LocalDate birthDate;

    @Column(length = 30)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(unique = true, nullable = false, length = 15)
    private String username;

    @Column(nullable = false)
    private String password;

    // Getters y Setters
    public String getDocumentNumber() { return documentNumber; }
    public void setDocumentNumber(String documentNumber) { this.documentNumber = documentNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}