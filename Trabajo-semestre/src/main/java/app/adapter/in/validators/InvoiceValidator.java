package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class InvoiceValidator extends SimpleValidator {
    
    public long idValidator(String value) throws Exception {
        return longValidator("ID de Factura", value);
    }

    public double amountValidator(String value) throws Exception {
        return doubleValidator("Monto de Factura", value);
    }
}