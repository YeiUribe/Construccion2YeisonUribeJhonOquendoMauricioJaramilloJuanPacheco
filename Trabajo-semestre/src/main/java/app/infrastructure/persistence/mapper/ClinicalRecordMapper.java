package app.infrastructure.persistence.mapper;

import app.domain.model.ClinicalRecord;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;

public final class ClinicalRecordMapper {

    private ClinicalRecordMapper() {}

    public static ClinicalRecordEntity toEntity(ClinicalRecord domain) {
        if (domain == null) return null;
        ClinicalRecordEntity entity = new ClinicalRecordEntity();
        // no asignar id si es el valor por defecto 0, para permitir INSERT
        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }
        // NO asignar patient ni doctor aquí - el adapter lo resuelve desde BD
        // entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        // entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setRecordDate(domain.getRecordDate());
        // NO asignar vitals y clinicalOrder - pueden ser null y crear entidades transitorias
        entity.setReasonForVisit(domain.getReasonForVisit());
        entity.setSymptoms(domain.getSymptoms());
        entity.setDiagnosis(domain.getDiagnosis());
        return entity;
    }

    public static ClinicalRecord toDomain(ClinicalRecordEntity entity) {
        if (entity == null) return null;
        ClinicalRecord domain = new ClinicalRecord();
        domain.setId(entity.getId()); // Asumiendo que el dominio tiene ID
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setRecordDate(entity.getRecordDate());
        domain.setVitals(PatientVitalsMapper.toDomain(entity.getVitals()));
        domain.setReasonForVisit(entity.getReasonForVisit());
        domain.setSymptoms(entity.getSymptoms());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setClinicalOrder(ClinicalOrderMapper.toDomain(entity.getClinicalOrder()));
        return domain;
    }
}