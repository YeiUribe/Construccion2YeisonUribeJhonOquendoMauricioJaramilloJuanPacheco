package app.domain.ports;

import app.domain.model.Procedure;
import java.util.List;

public interface ProcedurePort {

    void save(Procedure procedure);

    Procedure findById(long id);

    List<Procedure> findAll();
    
    Procedure findByName(String name);
}
