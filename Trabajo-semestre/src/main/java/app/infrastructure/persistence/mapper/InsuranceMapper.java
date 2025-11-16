package app.infrastructure.persistence.mapper;

import app.domain.model.Insurance;
import app.infrastructure.persistence.entities.InsuranceEntity;

public final class InsuranceMapper {

    private InsuranceMapper() {}

    public static InsuranceEntity toEntity(Insurance domain) {
        if (domain == null) return null;
        InsuranceEntity entity = new InsuranceEntity();
        // evitar asignar id cuando el domain.id es el valor por defecto 0
        // (el modelo de dominio usa `long` primitivo, cuyo valor por defecto es 0).
        // Si se asigna 0 aquí, JPA interpreta la entidad como existente y ejecuta
        // un SELECT por id en lugar de hacer un INSERT.
        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }
        entity.setCompanyName(domain.getCompanyName());
        entity.setContactNumber(domain.getContactNumber());
        entity.setActive(domain.isActive());
        return entity;
    }

    public static Insurance toDomain(InsuranceEntity entity) {
        if (entity == null) return null;
        Insurance domain = new Insurance();
        domain.setId(entity.getId());
        domain.setCompanyName(entity.getCompanyName());
        domain.setContactNumber(entity.getContactNumber());
        domain.setActive(entity.isActive());
        return domain;
    }
}
