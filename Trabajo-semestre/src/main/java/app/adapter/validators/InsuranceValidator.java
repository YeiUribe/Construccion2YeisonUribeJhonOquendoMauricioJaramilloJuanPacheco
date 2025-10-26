package app.adapter.validators;

import org.springframework.stereotype.Component;

@Component
public class InsuranceValidator extends SimpleValidator {

    public String companyNameValidator(String value) throws Exception {
        
        return super.stringValidator("Nombre de la compañía de seguros", value);
    }

    public long idValidator(String value) throws Exception {
        
        return super.longValidator("ID de Aseguradora", value);
    }

    public String nameValidator(String value) throws Exception {
        
        return super.stringValidator("Nombre de Aseguradora", value);
    }

    public String phoneValidator(String value) throws Exception {
        
        return super.stringValidator("Teléfono de Aseguradora", value);
    }

    public boolean stateValidator(String value) throws Exception {
        
        return super.booleanValidator("Estado de Aseguradora", value);
    }
}
