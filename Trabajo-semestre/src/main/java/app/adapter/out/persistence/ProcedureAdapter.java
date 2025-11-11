package app.adapter.out.persistence;

import app.domain.model.Procedure;
import app.domain.ports.ProcedurePort;
import app.infrastructure.persistence.entities.ProcedureEntity;
import app.infrastructure.persistence.mapper.ProcedureMapper;
import app.infrastructure.persistence.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProcedureAdapter implements ProcedurePort {
    
    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public void save(Procedure procedure) throws Exception {
        ProcedureEntity entity = ProcedureMapper.toEntity(procedure);
        procedureRepository.save(entity);
    }

    @Override
    public Procedure findById(long id) throws Exception {
        return procedureRepository.findById(id)
                .map(ProcedureMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Procedure> findAll() throws Exception {
        return procedureRepository.findAll().stream()
                .map(ProcedureMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Procedure findByName(String name) throws Exception {
        ProcedureEntity entity = procedureRepository.findByName(name);
        return ProcedureMapper.toDomain(entity);
    }
}