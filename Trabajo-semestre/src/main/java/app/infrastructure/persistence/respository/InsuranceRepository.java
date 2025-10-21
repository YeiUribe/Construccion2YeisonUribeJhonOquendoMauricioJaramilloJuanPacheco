package app.infrastructure.persistence.respository;

import app.infrastructure.persistence.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceEntity, Long> {
    InsuranceEntity findByCompanyName(String companyName);
}