package app.adapter.out.persistence;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.ClinicalOrderMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.ClinicalOrderRepository;
import app.infrastructure.persistence.repository.PatientRepository;
import app.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClinicalOrderAdapter implements ClinicalOrderPort {
    
    @Autowired
    private ClinicalOrderRepository clinicalOrderRepository;
    
    @Autowired
    private PatientRepository patientRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(ClinicalOrder order) throws Exception {
        ClinicalOrderEntity entity = ClinicalOrderMapper.toEntity(order);
        
        // Resolver paciente desde BD para evitar entidad transitoria
        PatientEntity pe = patientRepository.findByIdentificationNumber(order.getPatient().getIdentificationNumber());
        if (pe == null) {
            throw new IllegalStateException("Paciente no encontrado con identificación: " + order.getPatient().getIdentificationNumber());
        }
        entity.setPatient(pe);
        
        // Resolver doctor desde BD para evitar entidad transitoria
        UserEntity ue = userRepository.findByDocumentNumber(order.getDoctor().getDocumentNumber());
        if (ue == null) {
            throw new IllegalStateException("Doctor no encontrado con documento: " + order.getDoctor().getDocumentNumber());
        }
        entity.setDoctor(ue);
        
        // Asignar la orden clínica a cada item (medicamento, procedimiento, ayuda diagnóstica)
        if (entity.getMedications() != null) {
            entity.getMedications().forEach(med -> med.setClinicalOrder(entity));
        }
        if (entity.getProcedures() != null) {
            entity.getProcedures().forEach(proc -> proc.setClinicalOrder(entity));
        }
        if (entity.getDiagnosticAids() != null) {
            entity.getDiagnosticAids().forEach(aid -> aid.setClinicalOrder(entity));
        }
        
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