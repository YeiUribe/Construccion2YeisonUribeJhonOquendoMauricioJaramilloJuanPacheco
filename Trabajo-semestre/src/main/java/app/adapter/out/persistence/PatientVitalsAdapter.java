package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.PatientVitals;
import app.domain.ports.PatientVitalsPort;
import app.infrastructure.persistence.entities.PatientVitalsEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.PatientVitalsMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.PatientVitalsRepository;

@Service
public class PatientVitalsAdapter implements PatientVitalsPort {

    @Autowired
    private PatientVitalsRepository patientVitalsRepository;

    @Override
    public PatientVitals findByPatient(PatientVitals vitals) throws Exception {
        PatientEntity patientEntity = PatientMapper.toEntity(vitals.getPatient());
        PatientVitalsEntity entity = patientVitalsRepository.findByPatient(patientEntity);
        return PatientVitalsMapper.toDomain(entity);
    }

    @Override
    public PatientVitals findByTimestamp(PatientVitals vitals) throws Exception {
        PatientVitalsEntity entity = patientVitalsRepository.findByRecordTimestamp(vitals.getRecordTimestamp());
        return PatientVitalsMapper.toDomain(entity);
    }

    @Override
    public PatientVitals save(PatientVitals vitals) throws Exception {
        PatientVitalsEntity entity = PatientVitalsMapper.toEntity(vitals);
        PatientVitalsEntity savedEntity = patientVitalsRepository.save(entity);
        return PatientVitalsMapper.toDomain(savedEntity);
    }
}
