package app.adapter.out.persistence;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.ClinicalRecordPort;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.mapper.ClinicalRecordMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.ClinicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicalRecordAdapter implements ClinicalRecordPort {
    
    @Autowired
    private ClinicalRecordRepository clinicalRecordRepository;

    @Override
    public void save(ClinicalRecord record) throws Exception {
        ClinicalRecordEntity entity = ClinicalRecordMapper.toEntity(record);
        clinicalRecordRepository.save(entity);
    }

    @Override
    public List<ClinicalRecord> findByPatient(Patient patient) throws Exception {
        List<ClinicalRecordEntity> entities = clinicalRecordRepository.findByPatient(PatientMapper.toEntity(patient));
        return entities.stream()
                       .map(ClinicalRecordMapper::toDomain)
                       .collect(Collectors.toList());
    }
}