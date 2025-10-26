package app.adapter.validators;

import app.application.exceptions.InputsException;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class PatientValidator extends SimpleValidator {
    
    public String documentValidator(String value) throws Exception {
        return stringValidator("Cédula del Paciente", value);
    }
    
    public String stringValidator(String value) throws Exception {
        return stringValidator("Campo de texto", value);
    }

   
    public LocalDate dateValidator(String value) throws Exception {
        LocalDate date = super.dateValidator("Fecha de Nacimiento", value);
        if (date.isAfter(LocalDate.now())) {
            throw new InputsException("La fecha de nacimiento no puede ser en el futuro.");
        }
        return date;
    }
    
    public String phoneValidator(String value) throws Exception {
        long phone = longValidator("Número de Teléfono", value);
        if (String.valueOf(phone).length() > 10) {
            throw new InputsException("Número de Teléfono no puede tener más de 10 dígitos.");
        }
        return String.valueOf(phone);
    }


    public String emailValidator(String value) throws Exception {
        return super.emailValidator("Correo Electrónico", value);
    }
}