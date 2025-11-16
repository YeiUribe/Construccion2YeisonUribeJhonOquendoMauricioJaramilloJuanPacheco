package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, String> {
    PatientEntity findByIdentificationNumber(String identificationNumber);
}
