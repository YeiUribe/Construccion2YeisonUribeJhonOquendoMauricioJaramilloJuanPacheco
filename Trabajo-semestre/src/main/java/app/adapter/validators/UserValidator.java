package com.clinic.adapter.in.validator;

import app.adapter.validators.SimpleValidator;
import app.application.exceptions.InputsException;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class UserValidator extends SimpleValidator {

    public String documentValidator(String value) throws InputsException {
        return stringValidator("Número de Cédula", value);
    }
    
    public String stringValidator(String value) throws InputsException {
        return stringValidator("Nombre Completo", value);
    }

    @Override
    public String emailValidator(String value) throws InputsException {
        return super.emailValidator("Correo Electrónico", value);
    }

    public String phoneValidator(String value) throws InputsException {
        long phone = longValidator("Número de Teléfono", value);
        if (String.valueOf(phone).length() > 10) {
            throw new InputsException("Número de Teléfono no puede tener más de 10 dígitos.");
        }
        return String.valueOf(phone);
    }

    @Override
    public LocalDate dateValidator(String value) throws InputsException {
        LocalDate date = super.dateValidator("Fecha de Nacimiento", value);
        if (date.isAfter(LocalDate.now().minusYears(18))) {
             throw new InputsException("El empleado debe ser mayor de 18 años.");
        }
        return date;
    }

    public String addressValidator(String value) throws InputsException {
        stringValidator("Dirección", value);
        if (value.length() > 30) {
            throw new InputsException("Dirección no puede tener más de 30 caracteres.");
        }
        return value;
    }

    public String usernameValidator(String value) throws InputsException {
        stringValidator("Nombre de Usuario", value);
        if (value.length() > 15 || !value.matches("^[a-zA-Z0-9]+$")) {
            throw new InputsException("Nombre de Usuario debe ser max 15 caracteres, solo letras y números.");
        }
        return value;
    }

    public String passwordValidator(String value) throws InputsException {
        stringValidator("Contraseña", value);
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