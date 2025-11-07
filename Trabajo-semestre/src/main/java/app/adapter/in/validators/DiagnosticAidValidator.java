package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class DiagnosticAidValidator extends SimpleValidator {

    public String stringValidator(String value) throws Exception {
        return stringValidator("Nombre de Ayuda Diagnóstica", value);
    }

    public double doubleValidator(String value) throws Exception {
        return super.doubleValidator("Costo", value);
    }
}
