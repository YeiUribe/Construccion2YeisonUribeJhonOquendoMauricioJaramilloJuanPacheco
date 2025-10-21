package app.infrastructure.persistence.respository;

import app.infrastructure.persistence.entities.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<MedicationEntity, Long> {
}
