package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import app.infrastructure.persistence.entities.InsuranceEntity;
import app.infrastructure.persistence.mapper.InsuranceMapper;
import app.infrastructure.persistence.repository.InsuranceRepository;

@Service
public class InsuranceAdapter implements InsurancePort {
    
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public Insurance findById(Insurance insurance) throws Exception {
        // Cambiar a un método que no use findById de JPA
        InsuranceEntity entity = insuranceRepository.findByCompanyName(insurance.getCompanyName());
        return InsuranceMapper.toDomain(entity);
    }

    @Override
    public Insurance findByCompany(Insurance insurance) throws Exception {
        InsuranceEntity entity = insuranceRepository.findByCompanyName(insurance.getCompanyName());
        return InsuranceMapper.toDomain(entity);
    }

    @Override
    public void save(Insurance insurance) throws Exception {
        insuranceRepository.save(InsuranceMapper.toEntity(insurance));
    }
}