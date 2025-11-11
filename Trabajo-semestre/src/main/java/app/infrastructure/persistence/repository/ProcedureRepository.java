package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
	ProcedureEntity findByName(String name);
}