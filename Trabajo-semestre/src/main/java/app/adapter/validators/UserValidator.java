package app.adapter.validators;

import java.time.LocalDate;
import org.springframework.stereotype.Component;
import app.application.exceptions.InputsException;

@Component
public class UserValidator extends SimpleValidator {

    
    @Override
    public String documentValidator(String value) throws Exception {
        return super.stringValidator("Número de Cédula", value);
    }

    
    public String nameValidator(String value) throws Exception {
        return super.stringValidator("Nombre Completo", value);
    }

    
    public String emailValidator(String value) throws Exception {
        return super.emailValidator("Correo Electrónico", value);
    }

   
    public String phoneValidator(String value) throws Exception {
        long phone = super.longValidator("Número de Teléfono", value);
        if (String.valueOf(phone).length() > 10) {
            throw new InputsException("Número de Teléfono no puede tener más de 10 dígitos.");
        }
        return String.valueOf(phone);
    }

    
    @Override
    public LocalDate dateValidator(String value) throws Exception {
        LocalDate date = super.dateValidator("Fecha de Nacimiento", value);
        if (date.isAfter(LocalDate.now().minusYears(18))) {
            throw new InputsException("El empleado debe ser mayor de 18 años.");
        }
        return date;
    }

    
    public String addressValidator(String value) throws Exception {
        super.stringValidator("Dirección", value);
        if (value.length() > 30) {
            throw new InputsException("Dirección no puede tener más de 30 caracteres.");
        }
        return value;
    }

    
    public String usernameValidator(String value) throws Exception {
        super.stringValidator("Nombre de Usuario", value);
        if (value.length() > 15 || !value.matches("^[a-zA-Z0-9]+$")) {
            throw new InputsException("Nombre de Usuario debe tener máximo 15 caracteres, solo letras y números.");
        }
        return value;
    }

    
    public String passwordValidator(String value) throws Exception {
        super.stringValidator("Contraseña", value);

        if (value.length() < 8) {
            throw new InputsException("Contraseña debe tener al menos 8 caracteres.");
        }
        if (!value.matches(".*[A-Z].*")) {
            throw new InputsException("Contraseña debe tener al menos una mayúscula.");
        }
        if (!value.matches(".*[0-9].*")) {
            throw new InputsException("Contraseña debe tener al menos un número.");
        }
        if (!value.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new InputsException("Contraseña debe tener al menos un carácter especial.");
        }

        return value;
    }
}
