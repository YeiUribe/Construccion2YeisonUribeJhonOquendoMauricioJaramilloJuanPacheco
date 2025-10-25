package app.adapter.validators;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class InsuranceValidator extends SimpleValidator {

    public String companyNameValidator(String value) throws Exception {
        return stringValidator("Nombre de la compañía de seguros", value, 100);
    }

    public String policyNumberValidator(String value) throws Exception {
        return stringValidator("Número de póliza", value, 50);
    }
    
    public String statusValidator(String value) throws Exception {
        return stringValidator("Estado de la póliza", value, 20);
    }
    
    public LocalDate expirationDateValidator(LocalDate value) throws Exception {
        if (value == null) {
            throw new Exception("La fecha de vencimiento de la póliza no puede estar vacía");
        }
        if (value.isBefore(LocalDate.now())) {
            throw new Exception("La fecha de vencimiento no puede ser anterior a la fecha actual");
        }
        return value;
    }
}