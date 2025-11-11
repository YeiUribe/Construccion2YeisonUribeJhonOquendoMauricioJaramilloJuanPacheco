package app.infrastructure.persistence.mapper;

import app.domain.model.ClinicalOrder;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import java.util.stream.Collectors;

public final class ClinicalOrderMapper {

    private ClinicalOrderMapper() {}

    public static ClinicalOrderEntity toEntity(ClinicalOrder domain) {
        if (domain == null) return null;
        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        entity.setId(domain.getId());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setCreationDate(domain.getCreationDate());

        if (domain.getMedications() != null) {
            entity.setMedications(domain.getMedications().stream()
                .map(MedicationMapper::toEntity)
                .peek(medEntity -> medEntity.setClinicalOrder(entity)) 
                .collect(Collectors.toList()));
        }
        if (domain.getProcedures() != null) {
            entity.setProcedures(domain.getProcedures().stream()
                .map(ProcedureMapper::toEntity)
                .peek(procEntity -> procEntity.setClinicalOrder(entity))
                .collect(Collectors.toList()));
        }
        if (domain.getDiagnosticAids() != null) {
            entity.setDiagnosticAids(domain.getDiagnosticAids().stream()
                .map(DiagnosticAidMapper::toEntity)
                .peek(aidEntity -> aidEntity.setClinicalOrder(entity))
                .collect(Collectors.toList()));
        }
        return entity;
    }

    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) return null;
        ClinicalOrder domain = new ClinicalOrder();
        domain.setId(entity.getId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setCreationDate(entity.getCreationDate());

        if (entity.getMedications() != null) {
            domain.setMedications(entity.getMedications().stream()
                .map(MedicationMapper::toDomain)
                .collect(Collectors.toList()));
        }
        if (entity.getProcedures() != null) {
            domain.setProcedures(entity.getProcedures().stream()
                .map(ProcedureMapper::toDomain)
                .collect(Collectors.toList()));
        }
        if (entity.getDiagnosticAids() != null) {
            domain.setDiagnosticAids(entity.getDiagnosticAids().stream()
                .map(DiagnosticAidMapper::toDomain)
                .collect(Collectors.toList()));
        }
        return domain;
    }
}