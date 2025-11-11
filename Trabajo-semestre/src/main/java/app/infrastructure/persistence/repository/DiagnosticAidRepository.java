package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.DiagnosticAidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticAidRepository extends JpaRepository<DiagnosticAidEntity, Long> {

	DiagnosticAidEntity findByName(String name);
}