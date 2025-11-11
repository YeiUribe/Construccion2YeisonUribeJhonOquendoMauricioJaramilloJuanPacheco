package app.infrastructure.persistence.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmergencyContactEmbeddable {

    private String ecFullName;
    private String ecRelationship;
    private String ecPhoneNumber;

    // Getters y Setters
    public String getEcFullName() { return ecFullName; }
    public void setEcFullName(String ecFullName) { this.ecFullName = ecFullName; }
    public String getEcRelationship() { return ecRelationship; }
    public void setEcRelationship(String ecRelationship) { this.ecRelationship = ecRelationship; }
    public String getEcPhoneNumber() { return ecPhoneNumber; }
    public void setEcPhoneNumber(String ecPhoneNumber) { this.ecPhoneNumber = ecPhoneNumber; }
}
