package app.adapter.rest.mapper;

import app.adapter.rest.request.DiagnosticAidRequest;
import app.adapter.rest.request.InventoryItemRequest;
import app.adapter.rest.response.DiagnosticAidResponse;
import app.domain.model.DiagnosticAid;

public class DiagnosticAidMapper {

    public static DiagnosticAid toDomain(DiagnosticAidRequest req) {
        if (req == null) return null;
        DiagnosticAid d = new DiagnosticAid();
        d.setItemNumber(req.getItemNumber());
        d.setName(req.getName());
        d.setQuantity(req.getQuantity());
        d.setRequiresSpecialist(req.isRequiresSpecialist());
        d.setCost(req.getCost());
        return d;
    }

    public static DiagnosticAid toDomain(InventoryItemRequest req) {
        if (req == null) return null;
        DiagnosticAid d = new DiagnosticAid();
        d.setName(req.getName());
        d.setCost(req.getCost());
        return d;
    }

    public static DiagnosticAidResponse toResponse(DiagnosticAid d) {
        if (d == null) return null;
        DiagnosticAidResponse r = new DiagnosticAidResponse();
        r.setItemNumber(d.getItemNumber());
        r.setName(d.getName());
        r.setQuantity(d.getQuantity());
        r.setRequiresSpecialist(d.isRequiresSpecialist());
        r.setSpecialty(d.getSpecialty() != null ? d.getSpecialty().name() : null);
        r.setCost(d.getCost());
        return r;
    }
}
