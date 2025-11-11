package app.adapter.in.rest.request;

public class PatientRequest {
    private String identificationNumber;
    private String fullName;
    private String birthDate;
    private String gender; 
    private String address;
    private String phoneNumber;
    private String email;
    private String ecFullName;
    private String ecRelationship;
    private String ecPhoneNumber;
    private String insuranceId;

    // Getters y Setters
    public String getIdentificationNumber() { return identificationNumber; }
    public void setIdentificationNumber(String identificationNumber) { this.identificationNumber = identificationNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEcFullName() { return ecFullName; }
    public void setEcFullName(String ecFullName) { this.ecFullName = ecFullName; }
    public String getEcRelationship() { return ecRelationship; }
    public void setEcRelationship(String ecRelationship) { this.ecRelationship = ecRelationship; }
    public String getEcPhoneNumber() { return ecPhoneNumber; }
    public void setEcPhoneNumber(String ecPhoneNumber) { this.ecPhoneNumber = ecPhoneNumber; }
    public String getInsuranceId() { return insuranceId; }
    public void setInsuranceId(String insuranceId) { this.insuranceId = insuranceId; }
}