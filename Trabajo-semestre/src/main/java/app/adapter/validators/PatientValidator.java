package app.adapter.validators;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class PatientValidator extends SimpleValidator {

    public String fullNameValidator(String value) throws Exception {
        return stringValidator("Nombre completo del paciente", value, 100);
    }

    public String identificationValidator(String value) throws Exception {
        stringValidator("Identificación del paciente", value, 20);
        if (!value.matches("^\\d{1,20}$")) {
            throw new Exception("La identificación debe contener solo números");
        }
        return value;
    }
    
    public LocalDate birthDateValidator(LocalDate value) throws Exception {
        if (value == null) {
            throw new Exception("La fecha de nacimiento no puede estar vacía");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new Exception("La fecha de nacimiento no puede ser futura");
        }
        return value;
    }
    
    public String genderValidator(String value) throws Exception {
        return stringValidator("Género", value, 20);
    }
    
    public String addressValidator(String value) throws Exception {
        return stringValidator("Dirección", value, 200);
    }
    
    public String phoneValidator(String value) throws Exception {
        stringValidator("Teléfono", value, 10);
        if (!value.matches("^\\d{1,10}$")) {
            throw new Exception("El teléfono debe contener entre 1 y 10 dígitos");
        }
        return value;
    }
    
    public String emailValidator(String value) throws Exception {
        return emailValidator(value);
    }
}