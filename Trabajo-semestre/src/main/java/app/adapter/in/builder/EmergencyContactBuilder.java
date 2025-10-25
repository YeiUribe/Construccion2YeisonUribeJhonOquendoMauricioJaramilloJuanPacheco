package app.adapter.in.builder;

import app.domain.model.EmergencyContact;

public class EmergencyContactBuilder {
    private String fullName;
    private String relationship;
    private String phoneNumber;

    public static EmergencyContactBuilder builder() {
        return new EmergencyContactBuilder();
    }

    public EmergencyContactBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public EmergencyContactBuilder withRelationship(String relationship) {
        this.relationship = relationship;
        return this;
    }

    public EmergencyContactBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmergencyContact build() {
        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setFullName(fullName);
        emergencyContact.setRelationship(relationship);
        emergencyContact.setPhoneNumber(phoneNumber);
        return emergencyContact;
    }
}