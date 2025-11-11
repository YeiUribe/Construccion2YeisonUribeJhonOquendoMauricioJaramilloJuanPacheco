package app.adapter.out.persistence;

import app.domain.model.Invoice;
import app.domain.model.Patient;
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

    @Override
    public void save(Invoice invoice) throws Exception {
        InvoiceEntity entity = InvoiceMapper.toEntity(invoice);
        invoiceRepository.save(entity);
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