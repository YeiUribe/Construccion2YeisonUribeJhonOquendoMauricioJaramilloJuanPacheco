package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
    InsuranceEntity findByCompanyName(String companyName);
}