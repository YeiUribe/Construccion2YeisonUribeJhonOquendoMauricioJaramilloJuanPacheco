package app.adapter.out.persistence;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientAdapter implements PatientPort {
    
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void save(Patient patient) throws Exception {
        PatientEntity entity = PatientMapper.toEntity(patient);
        patientRepository.save(entity);
    }

    @Override
    public Patient findByIdentificationNumber(String identificationNumber) throws Exception {
        PatientEntity entity = patientRepository.findByIdentificationNumber(identificationNumber);
        return PatientMapper.toDomain(entity);
    }
}
