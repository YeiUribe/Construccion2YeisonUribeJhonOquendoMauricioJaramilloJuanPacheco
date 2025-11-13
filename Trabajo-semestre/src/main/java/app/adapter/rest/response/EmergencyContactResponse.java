package app.adapter.rest.response;

public class EmergencyContactResponse {
    private String fullName;
    private String relationship;
    private String phoneNumber;

    public EmergencyContactResponse() {}

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
