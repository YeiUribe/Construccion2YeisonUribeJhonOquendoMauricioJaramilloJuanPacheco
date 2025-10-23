package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
    InvoiceEntity findById(long id);
    List<InvoiceEntity> findByPatient(PatientEntity patient);
}