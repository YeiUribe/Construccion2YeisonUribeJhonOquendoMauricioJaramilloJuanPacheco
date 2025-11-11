package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.PatientVitalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository

public interface PatientVitalsRepository extends JpaRepository<PatientVitalsEntity, Long> {
    
	List<PatientVitalsEntity> findByRecordTimestamp(LocalDateTime recordTimestamp);
    
    List<PatientVitalsEntity> findByPatient(PatientEntity patient);
    
}