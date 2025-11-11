package app.infrastructure.persistence.mapper;

import app.domain.model.Insurance;
import app.infrastructure.persistence.entities.InsuranceEntity;

public final class InsuranceMapper {

    private InsuranceMapper() {}

    public static InsuranceEntity toEntity(Insurance domain) {
        if (domain == null) return null;
        InsuranceEntity entity = new InsuranceEntity();
        entity.setId(domain.getId());
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
