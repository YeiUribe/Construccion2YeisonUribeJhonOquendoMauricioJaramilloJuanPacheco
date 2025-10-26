package app.adapter.in.validators;

import app.application.exceptions.InputsException;
import org.springframework.stereotype.Component;

@Component
public class MedicationValidator extends SimpleValidator {
    
    public String stringValidator(String value) throws Exception {
        return stringValidator("Nombre del Medicamento", value);
    }

    public double doubleValidator(String value) throws Exception {
        return super.doubleValidator("Costo", value);
    }
}
