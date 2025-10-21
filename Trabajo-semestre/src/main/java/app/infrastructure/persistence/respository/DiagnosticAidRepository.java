package app.infrastructure.persistence.respository;

import app.infrastructure.persistence.entities.DiagnosticAidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosticAidRepository extends JpaRepository<DiagnosticAidEntity, Long> {
}