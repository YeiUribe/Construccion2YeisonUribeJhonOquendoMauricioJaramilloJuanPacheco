package app.adapter.out.persistence;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import app.infrastructure.persistence.entities.InsuranceEntity;
import app.infrastructure.persistence.mapper.InsuranceMapper;
import app.infrastructure.persistence.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsuranceAdapter implements InsurancePort {
    
    @Autowired
    private InsuranceRepository insuranceRepository;

    @Override
    public void save(Insurance insurance) throws Exception {
        InsuranceEntity entity = InsuranceMapper.toEntity(insurance);
        insuranceRepository.save(entity);
    }

    
    @Override
    public Insurance findById(Insurance insurance) throws Exception {
        return insuranceRepository.findById(insurance.getId()) // Extrae el ID del objeto
                .map(InsuranceMapper::toDomain)
                .orElse(null);
    }

    
    @Override
    public Insurance findByCompany(Insurance insurance) throws Exception {
        InsuranceEntity entity = insuranceRepository.findByCompanyName(insurance.getCompanyName());
        return InsuranceMapper.toDomain(entity);
    }
    
   
    @Override
    public Insurance findByCompanyName(String companyName) throws Exception {
        InsuranceEntity entity = insuranceRepository.findByCompanyName(companyName);
        return InsuranceMapper.toDomain(entity);
    }
}