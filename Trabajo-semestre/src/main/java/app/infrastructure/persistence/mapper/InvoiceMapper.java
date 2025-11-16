package app.infrastructure.persistence.mapper;

import app.domain.model.Invoice;
import app.infrastructure.persistence.entities.InvoiceEntity;

public final class InvoiceMapper {

    private InvoiceMapper() {}

    public static InvoiceEntity toEntity(Invoice domain) {
        if (domain == null) return null;
        InvoiceEntity entity = new InvoiceEntity();
        // no setear id si es el valor por defecto 0
        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }
        entity.setIssueDate(domain.getIssueDate());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setTotalAmount(domain.getTotalAmount());
        entity.setCopayAmount(domain.getCopayAmount());
        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) return null;
        Invoice domain = new Invoice();
        domain.setId(entity.getId());
        domain.setIssueDate(entity.getIssueDate());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setTotalAmount(entity.getTotalAmount());
        domain.setCopayAmount(entity.getCopayAmount());
        return domain;
    }
}
