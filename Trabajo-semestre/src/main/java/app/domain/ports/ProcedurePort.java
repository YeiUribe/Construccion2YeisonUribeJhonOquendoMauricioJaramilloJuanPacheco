package app.domain.ports;

import app.domain.model.Procedure;
import java.util.List;

public interface ProcedurePort {

    void save(Procedure procedure) throws Exception;

    Procedure findById(long id) throws Exception;

    List<Procedure> findAll() throws Exception;
    
    Procedure findByName(String name) throws Exception;
}
