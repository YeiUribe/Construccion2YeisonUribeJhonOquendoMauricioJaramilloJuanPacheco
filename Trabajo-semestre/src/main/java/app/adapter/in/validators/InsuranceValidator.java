package app.adapter.in.validators;

import app.application.exceptions.InputsException;
import org.springframework.stereotype.Component;

@Component
public class InsuranceValidator extends SimpleValidator {

    public long idValidator(String value) throws Exception {
        return longValidator("ID de Aseguradora", value);
    }

    public String stringValidator(String value) throws Exception {
        return stringValidator("Nombre de Aseguradora", value);
    }
    
    public String phoneValidator(String value) throws Exception {
        // Asume una validación simple de teléfono, se puede ajustar
        return stringValidator("Teléfono de Aseguradora", value);
    }

    public boolean booleanValidator(String value) throws Exception {
        return super.booleanValidator("Estado de Aseguradora", value);
    }
}
