package app.adapter.in.builder;

import app.adapter.in.validators.ProcedureValidator;
import app.domain.model.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcedureBuilder {

    @Autowired
    private ProcedureValidator procedureValidator;

    public Procedure build(String name, String cost) throws Exception {
        Procedure procedure = new Procedure();
        procedure.setName(procedureValidator.stringValidator(name));
        procedure.setCost(procedureValidator.doubleValidator(cost));
        return procedure;
    }
}