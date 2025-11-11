package app.infrastructure.persistence.mapper;

import app.domain.model.Procedure;
import app.infrastructure.persistence.entities.ProcedureEntity;

public final class ProcedureMapper {

    private ProcedureMapper() {}

    public static ProcedureEntity toEntity(Procedure domain) {
        if (domain == null) return null;
        ProcedureEntity entity = new ProcedureEntity();
        entity.setId(domain.getId()); 
        entity.setItemNumber(domain.getItemNumber());
        entity.setName(domain.getName());
        entity.setRepetitionCount(domain.getRepetitionCount());
        entity.setFrequency(domain.getFrequency());
        entity.setRequiresSpecialist(domain.isRequiresSpecialist());
        entity.setSpecialty(domain.getSpecialty());
        entity.setCost(domain.getCost());
        return entity;
    }

    public static Procedure toDomain(ProcedureEntity entity) {
        if (entity == null) return null;
        Procedure domain = new Procedure();
        domain.setId(entity.getId());
        domain.setItemNumber(entity.getItemNumber());
        domain.setName(entity.getName());
        domain.setRepetitionCount(entity.getRepetitionCount());
        domain.setFrequency(entity.getFrequency());
        domain.setRequiresSpecialist(entity.isRequiresSpecialist());
        domain.setSpecialty(entity.getSpecialty());
        domain.setCost(entity.getCost());
        return domain;
    }
}