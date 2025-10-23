package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {
    List<ClinicalRecordEntity> findByPatient(PatientEntity patient);
}
