package app.domain.service;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;

public class InvoiceValidator {

    public Invoice validateInvoice(Invoice invoice) throws Exception {
        if (invoice == null) {
            throw new Exception("La factura no puede ser nula");
        }

        // Validar y establecer los campos
        invoice.setId(idValidator(invoice.getId()));

        if (invoice.getIssueDate() == null) {
            throw new Exception("La fecha de emisión no puede ser nula");
        }

        invoice.setIssueDate(issueDateValidator(invoice.getIssueDate()));
        invoice.setPatient(patientValidator(invoice.getPatient()));
        invoice.setDoctor(doctorValidator(invoice.getDoctor()));
        invoice.setTotalAmount(totalAmountValidator(invoice.getTotalAmount()));
        invoice.setCopayAmount(copayAmountValidator(invoice.getCopayAmount()));

        return invoice;
    }

    // -------------------------------------------------
    // 🔹 VALIDADORES INDIVIDUALES
    // -------------------------------------------------

    private String idValidator(String id) throws Exception {
        if (id == null || id.trim().isEmpty()) {
            throw new Exception("El ID no puede estar vacío");
        }
        return id;
    }

    private String issueDateValidator(String date) throws Exception {
        if (date == null || date.trim().isEmpty()) {
            throw new Exception("La fecha de emisión no puede estar vacía");
        }
        // Aquí podrías agregar una validación de formato de fecha (opcional)
        return date;
    }

    private Patient patientValidator(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }
        return patient;
    }

    private User doctorValidator(User doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("El doctor no puede ser nulo");
        }
        return doctor;
    }

    private String totalAmountValidator(String amount) throws Exception {
        if (amount == null || amount.trim().isEmpty()) {
            throw new Exception("El monto total no puede estar vacío");
        }
        try {
            double value = Double.parseDouble(amount);
            if (value <= 0) {
                throw new Exception("El monto total debe ser mayor que cero");
            }
        } catch (NumberFormatException e) {
            throw new Exception("El monto total debe ser un número válido");
        }
        return amount;
    }

    private String copayAmountValidator(String amount) throws Exception {
        if (amount == null || amount.trim().isEmpty()) {
            throw new Exception("El copago no puede estar vacío");
        }
        try {
            double value = Double.parseDouble(amount);
            if (value < 0) {
                throw new Exception("El copago no puede ser negativo");
            }
        } catch (NumberFormatException e) {
            throw new Exception("El copago debe ser un número válido");
        }
        return amount;
    }
}
