package app.adapter.out.persistence;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.repository.PatientRepository;
import app.infrastructure.persistence.repository.UserRepository;
import app.domain.ports.InvoicePort;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.mapper.InvoiceMapper;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceAdapter implements InvoicePort {
    
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(Invoice invoice) throws Exception {
        InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
        // ensure patient and doctor are managed entities (not transient)
        if (invoice.getPatient() != null && invoice.getPatient().getIdentificationNumber() != null) {
            PatientEntity pe = patientRepository.findByIdentificationNumber(invoice.getPatient().getIdentificationNumber());
            if (pe == null) {
                throw new IllegalStateException("Paciente no encontrado: " + invoice.getPatient().getIdentificationNumber());
            }
            entity.setPatient(pe);
        } else {
            throw new IllegalStateException("Factura debe incluir un paciente válido");
        }
        if (invoice.getDoctor() != null && invoice.getDoctor().getDocumentNumber() != null) {
            UserEntity ue = userRepository.findByDocumentNumber(invoice.getDoctor().getDocumentNumber());
            if (ue == null) {
                throw new IllegalStateException("Doctor no encontrado: " + invoice.getDoctor().getDocumentNumber());
            }
            entity.setDoctor(ue);
        } else {
            throw new IllegalStateException("Factura debe incluir un doctor válido");
        }

        InvoiceEntity saved = invoiceRepository.save(entity);
        // actualizar id del modelo de dominio con el id generado por la BD
        if (saved != null && saved.getId() != null) {
            invoice.setId(saved.getId());
        }
    }

    @Override
    public Invoice findById(long id) throws Exception {
        InvoiceEntity entity = invoiceRepository.findById(id);
        return InvoiceMapper.toDomain(entity);
    }

    @Override
    public List<Invoice> findByPatient(Patient patient) throws Exception {
        List<InvoiceEntity> entities = invoiceRepository.findByPatient(PatientMapper.toEntity(patient));
        return entities.stream()
                       .map(InvoiceMapper::toDomain)
                       .collect(Collectors.toList());
    }
}