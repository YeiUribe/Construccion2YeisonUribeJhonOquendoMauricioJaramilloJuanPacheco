package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticAid;
import app.infrastructure.persistence.entities.DiagnosticAidEntity;

public final class DiagnosticAidMapper {

    private DiagnosticAidMapper() {}

    public static DiagnosticAidEntity toEntity(DiagnosticAid domain) {
        if (domain == null) return null;
        DiagnosticAidEntity entity = new DiagnosticAidEntity();
        entity.setId(domain.getId()); 
        entity.setItemNumber(domain.getItemNumber());
        entity.setName(domain.getName());
        entity.setQuantity(domain.getQuantity());
        entity.setRequiresSpecialist(domain.isRequiresSpecialist());
        entity.setSpecialty(domain.getSpecialty());
        entity.setCost(domain.getCost());
        return entity;
    }

    public static DiagnosticAid toDomain(DiagnosticAidEntity entity) {
        if (entity == null) return null;
        DiagnosticAid domain = new DiagnosticAid();
        domain.setId(entity.getId()); 
        domain.setItemNumber(entity.getItemNumber());
        domain.setName(entity.getName());
        domain.setQuantity(entity.getQuantity());
        domain.setRequiresSpecialist(entity.isRequiresSpecialist());
        domain.setSpecialty(entity.getSpecialty());
        domain.setCost(entity.getCost());
        return domain;
    }
}