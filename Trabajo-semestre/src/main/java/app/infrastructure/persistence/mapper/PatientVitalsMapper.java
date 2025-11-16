package app.infrastructure.persistence.mapper;

import app.domain.model.PatientVitals;
import app.infrastructure.persistence.entities.PatientVitalsEntity;

public final class PatientVitalsMapper {

    private PatientVitalsMapper() {}

    public static PatientVitalsEntity toEntity(PatientVitals domain) {
        if (domain == null) return null;
        PatientVitalsEntity entity = new PatientVitalsEntity();
        // evitar asignar id cuando domain.id == 0 (valor por defecto de `long`)
        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setRecordTimestamp(domain.getRecordTimestamp());
        entity.setBloodPressure(domain.getBloodPressure());
        entity.setTemperature(domain.getTemperature());
        entity.setPulse(domain.getPulse());
        entity.setOxygenLevel(domain.getOxygenLevel());
        return entity;
    }

    public static PatientVitals toDomain(PatientVitalsEntity entity) {
        if (entity == null) return null;
        PatientVitals domain = new PatientVitals();
        domain.setId(entity.getId()); // Asumiendo que el dominio tiene ID
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setRecordTimestamp(entity.getRecordTimestamp());
        domain.setBloodPressure(entity.getBloodPressure());
        domain.setTemperature(entity.getTemperature());
        domain.setPulse(entity.getPulse());
        domain.setOxygenLevel(entity.getOxygenLevel());
        return domain;
    }
}