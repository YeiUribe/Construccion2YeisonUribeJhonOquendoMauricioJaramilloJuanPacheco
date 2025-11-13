package app.adapter.rest.mapper;

import app.adapter.rest.request.ProcedureRequest;
import app.adapter.rest.response.ProcedureResponse;
import app.domain.model.Procedure;

public class ProcedureMapper {

    public static Procedure toDomain(ProcedureRequest req) {
        if (req == null) return null;
        Procedure p = new Procedure();
        p.setItemNumber(req.getItemNumber());
        p.setName(req.getName());
        p.setRepetitionCount(req.getRepetitionCount());
        p.setFrequency(req.getFrequency());
        p.setRequiresSpecialist(req.isRequiresSpecialist());
        // specialty mapping left as string -> enum resolution in service
        p.setCost(req.getCost());
        return p;
    }

    public static ProcedureResponse toResponse(Procedure p) {
        if (p == null) return null;
        ProcedureResponse r = new ProcedureResponse();
        r.setItemNumber(p.getItemNumber());
        r.setName(p.getName());
        r.setRepetitionCount(p.getRepetitionCount());
        r.setFrequency(p.getFrequency());
        r.setRequiresSpecialist(p.isRequiresSpecialist());
        r.setSpecialty(p.getSpecialty() != null ? p.getSpecialty().name() : null);
        r.setCost(p.getCost());
        return r;
    }
}
