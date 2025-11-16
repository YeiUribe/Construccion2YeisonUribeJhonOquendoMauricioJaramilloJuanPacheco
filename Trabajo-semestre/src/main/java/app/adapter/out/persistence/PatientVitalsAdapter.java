package app.adapter.out.persistence;

import app.domain.model.PatientVitals;
import app.domain.ports.PatientVitalsPort;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.PatientVitalsEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.mapper.PatientVitalsMapper;
import app.infrastructure.persistence.repository.PatientRepository;
import app.infrastructure.persistence.repository.PatientVitalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientVitalsAdapter implements PatientVitalsPort {
    
    @Autowired
    private PatientVitalsRepository patientVitalsRepository;
    
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(PatientVitals vitals) throws Exception {
        PatientVitalsEntity entity = PatientVitalsMapper.toEntity(vitals);
        
        // Resolver paciente desde BD para evitar entidad transitoria
        PatientEntity pe = patientRepository.findByIdentificationNumber(vitals.getPatient().getIdentificationNumber());
        if (pe == null) {
            throw new IllegalStateException("Paciente no encontrado con identificación: " + vitals.getPatient().getIdentificationNumber());
        }
        entity.setPatient(pe);
        
        patientVitalsRepository.save(entity);
    }

 
    @Override
    public List<PatientVitals> findByTimestamp(PatientVitals vitals) throws Exception {
        List<PatientVitalsEntity> entities = patientVitalsRepository.findByRecordTimestamp(vitals.getRecordTimestamp());
        return entities.stream()
                       .map(PatientVitalsMapper::toDomain)
                       .collect(Collectors.toList());
    }


    @Override
    public List<PatientVitals> findByPatient(PatientVitals vitals) throws Exception {
        List<PatientVitalsEntity> entities = patientVitalsRepository.findByPatient(PatientMapper.toEntity(vitals.getPatient()));
        return entities.stream()
                       .map(PatientVitalsMapper::toDomain)
                       .collect(Collectors.toList());
    }
}