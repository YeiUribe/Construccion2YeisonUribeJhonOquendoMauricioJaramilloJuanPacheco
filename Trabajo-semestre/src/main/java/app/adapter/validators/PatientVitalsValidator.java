package app.adapter.validators;


import org.springframework.stereotype.Component;

@Component
public class PatientVitalsValidator extends SimpleValidator {
    
    public String stringValidator(String value) throws Exception {
        return stringValidator("Presión Arterial", value);
    }

    public double doubleValidator(String value) throws Exception {
        return super.doubleValidator("Signo Vital", value);
    }

    public int integerValidator(String value) throws Exception {
        return super.integerValidator("Pulso", value);
    }
}