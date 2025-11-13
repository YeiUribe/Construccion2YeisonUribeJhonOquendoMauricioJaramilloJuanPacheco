package app.adapter.rest.mapper;

import app.adapter.rest.request.InsuranceRequest;
import app.adapter.rest.response.InsuranceResponse;
import app.domain.model.Insurance;

public class InsuranceMapper {

    public static Insurance fromRequest(InsuranceRequest req) {
        if (req == null) return null;
        Insurance ins = new Insurance();
        ins.setCompanyName(req.getCompanyName());
        ins.setContactNumber(req.getContactNumber());
        ins.setActive(req.isActive());
        return ins;
    }

    public static Insurance toDomain(InsuranceRequest req) {
        return fromRequest(req);
    }

    public static InsuranceResponse toResponse(Insurance ins) {
        if (ins == null) return null;
        InsuranceResponse r = new InsuranceResponse();
        r.setId(ins.getId());
        r.setCompanyName(ins.getCompanyName());
        r.setContactNumber(ins.getContactNumber());
        r.setActive(ins.isActive());
        return r;
    }
}
