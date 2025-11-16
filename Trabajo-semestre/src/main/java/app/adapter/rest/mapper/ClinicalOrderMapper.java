package app.adapter.rest.mapper;

import app.adapter.rest.request.ClinicalOrderRequest;
import app.adapter.rest.response.ClinicalOrderResponse;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import java.util.stream.Collectors;
import java.util.List;

public class ClinicalOrderMapper {

    public static ClinicalOrder fromRequest(ClinicalOrderRequest req) {
        if (req == null) return null;
        ClinicalOrder o = new ClinicalOrder();
        
        // Crear Patient con identificationNumber
        if (req.getPatientId() != null) {
            Patient p = new Patient();
            p.setIdentificationNumber(req.getPatientId());
            o.setPatient(p);
        }
        
        // Crear User (doctor) con documentNumber
        if (req.getDoctorId() != null) {
            User d = new User();
            d.setDocumentNumber(req.getDoctorId());
            o.setDoctor(d);
        }
        
        o.setCreationDate(req.getCreationDate());
        if (req.getMedications() != null) {
            o.setMedications(req.getMedications().stream().map(MedicationMapper::toDomain).collect(Collectors.toList()));
        }
        if (req.getProcedures() != null) {
            o.setProcedures(req.getProcedures().stream().map(ProcedureMapper::toDomain).collect(Collectors.toList()));
        }
        if (req.getDiagnosticAids() != null) {
            o.setDiagnosticAids(req.getDiagnosticAids().stream().map(DiagnosticAidMapper::toDomain).collect(Collectors.toList()));
        }
        return o;
    }

    public static ClinicalOrder toDomain(ClinicalOrderRequest req) {
        return fromRequest(req);
    }

    public static ClinicalOrderResponse toResponse(ClinicalOrder o) {
        if (o == null) return null;
        ClinicalOrderResponse r = new ClinicalOrderResponse();
        r.setId(o.getId());
        Patient p = o.getPatient();
        if (p != null) {
            r.setPatientId(p.getIdentificationNumber());
            r.setPatientName(p.getFullName());
        }
        User d = o.getDoctor();
        if (d != null) {
            r.setDoctorId(d.getDocumentNumber());
            r.setDoctorName(d.getFullName());
        }
        r.setCreationDate(o.getCreationDate());
        if (o.getMedications() != null) {
            r.setMedications(o.getMedications().stream().map(MedicationMapper::toResponse).collect(Collectors.toList()));
        }
        if (o.getProcedures() != null) {
            r.setProcedures(o.getProcedures().stream().map(ProcedureMapper::toResponse).collect(Collectors.toList()));
        }
        if (o.getDiagnosticAids() != null) {
            r.setDiagnosticAids(o.getDiagnosticAids().stream().map(DiagnosticAidMapper::toResponse).collect(Collectors.toList()));
        }
        return r;
    }
}
