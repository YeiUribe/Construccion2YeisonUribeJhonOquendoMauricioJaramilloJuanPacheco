package app.adapter.validators;

<<<<<<< HEAD:Trabajo-semestre/src/main/java/com/clinic/adapter/in/validator/UserValidator.java
=======
import app.application.exceptions.InputsException;
import org.springframework.stereotype.Component;
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb:Trabajo-semestre/src/main/java/app/adapter/validators/UserValidator.java
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import app.application.exceptions.InputsException;

@Component
public class UserValidator extends SimpleValidator {

<<<<<<< HEAD:Trabajo-semestre/src/main/java/com/clinic/adapter/in/validator/UserValidator.java
    public String documentValidator(String value) throws InputsException {
        return stringValidator("Número de Cédula");
    }
    
    public String stringValidator(String value) throws InputsException {
        return stringValidator("Nombre Completo");
    }

    @Override
=======
    public String documentValidator(String value) throws Exception {
        return stringValidator("Número de Cédula", value);
    }
    
    public String stringValidator(String value) throws Exception {
        return stringValidator("Nombre Completo", value);
    }

>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb:Trabajo-semestre/src/main/java/app/adapter/validators/UserValidator.java
    public String emailValidator(String value) throws Exception {
        return super.emailValidator("Correo Electrónico", value);
    }

    public String phoneValidator(String value) throws Exception {
        long phone = longValidator("Número de Teléfono", value);
        if (String.valueOf(phone).length() > 10) {
            throw new InputsException("Número de Teléfono no puede tener más de 10 dígitos.");
        }
        return String.valueOf(phone);
    }

<<<<<<< HEAD:Trabajo-semestre/src/main/java/com/clinic/adapter/in/validator/UserValidator.java
    @Override
=======
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb:Trabajo-semestre/src/main/java/app/adapter/validators/UserValidator.java
    public LocalDate dateValidator(String value) throws Exception {
        LocalDate date = super.dateValidator("Fecha de Nacimiento", value);
        if (date.isAfter(LocalDate.now().minusYears(18))) {
             throw new InputsException("El empleado debe ser mayor de 18 años.");
        }
        return date;
    }

<<<<<<< HEAD:Trabajo-semestre/src/main/java/com/clinic/adapter/in/validator/UserValidator.java
    public String addressValidator(String value) throws InputsException {
        stringValidator("Dirección");
=======
    public String addressValidator(String value) throws Exception {
        stringValidator("Dirección", value);
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb:Trabajo-semestre/src/main/java/app/adapter/validators/UserValidator.java
        if (value.length() > 30) {
            throw new InputsException("Dirección no puede tener más de 30 caracteres.");
        }
        return value;
    }

<<<<<<< HEAD:Trabajo-semestre/src/main/java/com/clinic/adapter/in/validator/UserValidator.java
    public String usernameValidator(String value) throws InputsException {
        stringValidator("Nombre de Usuario");
=======
    public String usernameValidator(String value) throws Exception {
        stringValidator("Nombre de Usuario", value);
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb:Trabajo-semestre/src/main/java/app/adapter/validators/UserValidator.java
        if (value.length() > 15 || !value.matches("^[a-zA-Z0-9]+$")) {
            throw new InputsException("Nombre de Usuario debe ser max 15 caracteres, solo letras y números.");
        }
        return value;
    }

<<<<<<< HEAD:Trabajo-semestre/src/main/java/com/clinic/adapter/in/validator/UserValidator.java
    public String passwordValidator(String value) throws InputsException {
        stringValidator("Contraseña");
=======
    public String passwordValidator(String value) throws Exception {
        stringValidator("Contraseña", value);
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb:Trabajo-semestre/src/main/java/app/adapter/validators/UserValidator.java
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