package app.adapter.rest.mapper;

import app.adapter.rest.request.MedicationRequest;
import app.adapter.rest.response.MedicationResponse;
import app.domain.model.Medication;

public class MedicationMapper {

    public static Medication toDomain(MedicationRequest req) {
        if (req == null) return null;
        Medication m = new Medication();
        m.setItemNumber(req.getItemNumber());
        m.setName(req.getName());
        m.setDosage(req.getDosage());
        m.setDuration(req.getDuration());
        m.setCost(req.getCost());
        return m;
    }

    public static MedicationResponse toResponse(Medication m) {
        if (m == null) return null;
        MedicationResponse r = new MedicationResponse();
        r.setItemNumber(m.getItemNumber());
        r.setName(m.getName());
        r.setDosage(m.getDosage());
        r.setDuration(m.getDuration());
        r.setCost(m.getCost());
        return r;
    }
}
