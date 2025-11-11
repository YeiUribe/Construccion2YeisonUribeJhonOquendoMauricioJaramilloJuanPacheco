package app.adapter.out.persistence;

import app.domain.model.DiagnosticAid;
import app.domain.ports.DiagnosticAidPort;
import app.infrastructure.persistence.entities.DiagnosticAidEntity;
import app.infrastructure.persistence.mapper.DiagnosticAidMapper;
import app.infrastructure.persistence.repository.DiagnosticAidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiagnosticAidAdapter implements DiagnosticAidPort {
    
    @Autowired
    private DiagnosticAidRepository diagnosticAidRepository;

    @Override
    public void save(DiagnosticAid diagnosticAid) throws Exception {
        DiagnosticAidEntity entity = DiagnosticAidMapper.toEntity(diagnosticAid);
        diagnosticAidRepository.save(entity);
    }

    @Override
    public DiagnosticAid findById(long id) throws Exception {
        return diagnosticAidRepository.findById(id)
                .map(DiagnosticAidMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<DiagnosticAid> findAll() throws Exception {
        return diagnosticAidRepository.findAll().stream()
                .map(DiagnosticAidMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public DiagnosticAid findByName(String name) throws Exception {
        DiagnosticAidEntity entity = diagnosticAidRepository.findByName(name);
        return DiagnosticAidMapper.toDomain(entity);
    }
}