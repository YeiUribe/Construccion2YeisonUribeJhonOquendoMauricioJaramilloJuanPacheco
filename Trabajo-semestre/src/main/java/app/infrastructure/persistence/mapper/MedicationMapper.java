package app.infrastructure.persistence.mapper;

import app.domain.model.Medication;
import app.infrastructure.persistence.entities.MedicationEntity;

public final class MedicationMapper {

    private MedicationMapper() {}

    public static MedicationEntity toEntity(Medication domain) {
        if (domain == null) return null;
        MedicationEntity entity = new MedicationEntity();
        entity.setId(domain.getOrderId()); 
        entity.setItemNumber(domain.getItemNumber());
        entity.setName(domain.getName());
        entity.setDosage(domain.getDosage());
        entity.setDuration(domain.getDuration());
        entity.setCost(domain.getCost());
        return entity;
    }

    public static Medication toDomain(MedicationEntity entity) {
        if (entity == null) return null;
        Medication domain = new Medication();
        domain.setOrderId(entity.getId()); 
        domain.setItemNumber(entity.getItemNumber());
        domain.setName(entity.getName());
        domain.setDosage(entity.getDosage());
        domain.setDuration(entity.getDuration());
        domain.setCost(entity.getCost());
        return domain;
    }
}
