package app.domain.services;

import app.domain.model.Procedure;
import app.domain.ports.ProcedurePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProcedure {

    @Autowired
    private ProcedurePort procedurePort;

    public Procedure execute(Procedure procedure) {
        
        if (procedurePort.findByName(procedure.getName()) != null) {
            throw new IllegalStateException("Ya existe un procedimiento con el nombre: " + procedure.getName());
        }
        procedurePort.save(procedure);
        return procedure;
    }
}