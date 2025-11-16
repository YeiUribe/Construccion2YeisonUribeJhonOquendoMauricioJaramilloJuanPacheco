package app.adapter.rest.mapper;

import app.adapter.rest.request.InvoiceRequest;
import app.adapter.rest.response.InvoiceResponse;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;

public class InvoiceMapper {

    public static Invoice toDomain(InvoiceRequest req) {
        if (req == null) return null;
        Invoice i = new Invoice();
        i.setIssueDate(req.getIssueDate());
        i.setTotalAmount(req.getTotalAmount());
        // map patient and doctor IDs from request to lightweight domain objects
        if (req.getPatientId() != null) {
            app.domain.model.Patient p = new app.domain.model.Patient();
            // Patient.identificationNumber is a String PK; convert numeric id to String
            p.setIdentificationNumber(String.valueOf(req.getPatientId()));
            i.setPatient(p);
        }
        if (req.getDoctorId() != null) {
            app.domain.model.User d = new app.domain.model.User();
            d.setDocumentNumber(String.valueOf(req.getDoctorId()));
            i.setDoctor(d);
        }
        return i;
    }

    public static InvoiceResponse toResponse(Invoice i) {
        if (i == null) return null;
        InvoiceResponse r = new InvoiceResponse();
        r.setId(i.getId());
        r.setIssueDate(i.getIssueDate());
        Patient p = i.getPatient();
        if (p != null) {
            r.setPatientId(p.getIdentificationNumber());
            r.setPatientName(p.getFullName());
        }
        User d = i.getDoctor();
        if (d != null) {
            r.setDoctorId(d.getDocumentNumber());
            r.setDoctorName(d.getFullName());
        }
        r.setTotalAmount(i.getTotalAmount());
        r.setCopayAmount(i.getCopayAmount());
        return r;
    }
}
