package app.adapter.out.persistence;

import app.domain.model.Medication;
import app.domain.ports.MedicationPort;
import app.infrastructure.persistence.entities.MedicationEntity;
import app.infrastructure.persistence.mapper.MedicationMapper;
import app.infrastructure.persistence.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicationAdapter implements MedicationPort {
    
    @Autowired
    private MedicationRepository medicationRepository;

    @Override
    public void save(Medication medication) throws Exception {
        MedicationEntity entity = MedicationMapper.toEntity(medication);
        medicationRepository.save(entity);
    }

    @Override
    public Medication findById(long id) throws Exception {
        return medicationRepository.findById(id)
                .map(MedicationMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Medication> findAll() throws Exception {
        return medicationRepository.findAll().stream()
                .map(MedicationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Medication findByName(String name) throws Exception {
        MedicationEntity entity = medicationRepository.findByName(name);
        return MedicationMapper.toDomain(entity);
    }
}