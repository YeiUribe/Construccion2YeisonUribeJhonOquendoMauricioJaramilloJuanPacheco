package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;
import app.infrastructure.persistence.entities.EmergencyContactEntity;
import app.infrastructure.persistence.mapper.EmergencyContactMapper;
import app.infrastructure.persistence.repository.EmergencyContactRepository;

@Service
public class EmergencyContactAdapter implements EmergencyContactPort {
    
    @Autowired
    private EmergencyContactRepository emergencyContactRepository;

    @Override
    public EmergencyContact findById(EmergencyContact contact) throws Exception {
        // Cambiar a un método que no use findById de JPA
        EmergencyContactEntity entity = emergencyContactRepository.findByPhoneNumber(contact.getPhoneNumber());
        return EmergencyContactMapper.toDomain(entity);
    }

    @Override
    public EmergencyContact findByPhone(EmergencyContact contact) throws Exception {
        EmergencyContactEntity entity = emergencyContactRepository.findByPhoneNumber(contact.getPhoneNumber());
        return EmergencyContactMapper.toDomain(entity);
    }

    @Override
    public void save(EmergencyContact contact) throws Exception {
        emergencyContactRepository.save(EmergencyContactMapper.toEntity(contact));
    }
}