package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Long> {
    ClinicalOrderEntity findById(long id);
    List<ClinicalOrderEntity> findByPatient(PatientEntity patient);
}