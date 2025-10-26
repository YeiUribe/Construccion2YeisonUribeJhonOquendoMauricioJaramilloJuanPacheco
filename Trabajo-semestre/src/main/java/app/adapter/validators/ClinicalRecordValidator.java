package app.adapter.validators;

import org.springframework.stereotype.Component;

@Component
public class ClinicalRecordValidator extends SimpleValidator {
    
    public String stringValidator(String element, String value) throws Exception {
        return stringValidator("Campo de Historia Clínica (" + element + ")", value);
    }
}
