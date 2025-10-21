package app.infrastructure.persistence.respository;

import app.infrastructure.persistence.entities.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
}