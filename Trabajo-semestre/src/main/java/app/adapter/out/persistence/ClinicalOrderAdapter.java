package app.adapter.out.persistence;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.mapper.ClinicalOrderMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.ClinicalOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicalOrderAdapter implements ClinicalOrderPort {
    
    @Autowired
    private ClinicalOrderRepository clinicalOrderRepository;

    @Override
    public void save(ClinicalOrder order) throws Exception {
        ClinicalOrderEntity entity = ClinicalOrderMapper.toEntity(order);
        clinicalOrderRepository.save(entity);
    }

    @Override
    public ClinicalOrder findById(long id) throws Exception {
        ClinicalOrderEntity entity = clinicalOrderRepository.findById(id);
        return ClinicalOrderMapper.toDomain(entity);
    }

    @Override
    public List<ClinicalOrder> findByPatient(Patient patient) throws Exception {
        List<ClinicalOrderEntity> entities = clinicalOrderRepository.findByPatient(PatientMapper.toEntity(patient));
        return entities.stream()
                       .map(ClinicalOrderMapper::toDomain)
                       .collect(Collectors.toList());
    }
}