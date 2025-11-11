package app.infrastructure.persistence.mapper;

import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.infrastructure.persistence.entities.EmergencyContactEmbeddable;
import app.infrastructure.persistence.entities.PatientEntity;

public final class PatientMapper {

    private PatientMapper() {}

    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;
        PatientEntity entity = new PatientEntity();
        entity.setIdentificationNumber(domain.getIdentificationNumber());
        entity.setFullName(domain.getFullName());
        entity.setBirthDate(domain.getBirthDate());
        entity.setGender(domain.getGender());
        entity.setAddress(domain.getAddress());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setEmail(domain.getEmail());
        
        if (domain.getEmergencyContact() != null) {
            EmergencyContactEmbeddable contact = new EmergencyContactEmbeddable();
            contact.setEcFullName(domain.getEmergencyContact().getFullName());
            contact.setEcRelationship(domain.getEmergencyContact().getRelationship());
            contact.setEcPhoneNumber(domain.getEmergencyContact().getPhoneNumber());
            entity.setEmergencyContact(contact);
        }
        
        entity.setInsurance(InsuranceMapper.toEntity(domain.getInsurance()));
        
        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        Patient domain = new Patient();
        domain.setIdentificationNumber(entity.getIdentificationNumber());
        domain.setFullName(entity.getFullName());
        domain.setBirthDate(entity.getBirthDate());
        domain.setGender(entity.getGender());
        domain.setAddress(entity.getAddress());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setEmail(entity.getEmail());
        
        if (entity.getEmergencyContact() != null) {
            EmergencyContact contact = new EmergencyContact();
            contact.setFullName(entity.getEmergencyContact().getEcFullName());
            contact.setRelationship(entity.getEmergencyContact().getEcRelationship());
            contact.setPhoneNumber(entity.getEmergencyContact().getEcPhoneNumber());
            domain.setEmergencyContact(contact);
        }
        
        domain.setInsurance(InsuranceMapper.toDomain(entity.getInsurance()));
        
        return domain;
    }
}