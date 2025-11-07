package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class ProcedureValidator extends SimpleValidator {

    public String stringValidator(String value) throws Exception {
        return stringValidator("Nombre del Procedimiento", value);
    }

    public double doubleValidator(String value) throws Exception {
        return super.doubleValidator("Costo", value);
    }
}