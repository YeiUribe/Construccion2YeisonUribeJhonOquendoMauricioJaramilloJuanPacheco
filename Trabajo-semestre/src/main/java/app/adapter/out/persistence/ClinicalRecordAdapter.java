package app.adapter.out.persistence;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.ClinicalRecordPort;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.ClinicalRecordMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.ClinicalRecordRepository;
import app.infrastructure.persistence.repository.PatientRepository;
import app.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicalRecordAdapter implements ClinicalRecordPort {
    
    @Autowired
    private ClinicalRecordRepository clinicalRecordRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(ClinicalRecord record) throws Exception {
        ClinicalRecordEntity entity = ClinicalRecordMapper.toEntity(record);
        
        // Resolver paciente desde BD para evitar entidad transitoria
        PatientEntity pe = patientRepository.findByIdentificationNumber(record.getPatient().getIdentificationNumber());
        if (pe == null) {
            throw new IllegalStateException("Paciente no encontrado con identificación: " + record.getPatient().getIdentificationNumber());
        }
        entity.setPatient(pe);
        
        // Resolver doctor desde BD para evitar entidad transitoria
        UserEntity ue = userRepository.findByDocumentNumber(record.getDoctor().getDocumentNumber());
        if (ue == null) {
            throw new IllegalStateException("Doctor no encontrado con documento: " + record.getDoctor().getDocumentNumber());
        }
        entity.setDoctor(ue);
        
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