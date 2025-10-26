package app.adapter.validators;

import org.springframework.stereotype.Component;
<<<<<<< HEAD

import com.clinic.adapter.in.validator.SimpleValidator;

import java.time.LocalDate;
=======
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb

@Component
public class InsuranceValidator extends SimpleValidator {

<<<<<<< HEAD
    public String companyNameValidator(String value) throws Exception {
        return stringValidator("Nombre de la compañía de seguros", value, 0);
=======
    public long idValidator(String value) throws Exception {
        return longValidator("ID de Aseguradora", value);
>>>>>>> ca9889c6d5e2429ae86ef56a096593ab7ce50fbb
    }

    public String stringValidator(String value) throws Exception {
        return stringValidator("Nombre de Aseguradora", value);
    }
    
    public String phoneValidator(String value) throws Exception {
        return stringValidator("Teléfono de Aseguradora", value);
    }

    public boolean booleanValidator(String value) throws Exception {
        return super.booleanValidator("Estado de Aseguradora", value);
    }
}