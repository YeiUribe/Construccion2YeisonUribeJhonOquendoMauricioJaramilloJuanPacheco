package app.adapter.rest.mapper;

import app.adapter.rest.request.EmergencyContactRequest;
import app.adapter.rest.response.EmergencyContactResponse;
import app.domain.model.EmergencyContact;

public class EmergencyContactMapper {

    public static EmergencyContact toDomain(EmergencyContactRequest req) {
        if (req == null) return null;
        EmergencyContact ec = new EmergencyContact();
        ec.setFullName(req.getFullName());
        ec.setRelationship(req.getRelationship());
        ec.setPhoneNumber(req.getPhoneNumber());
        return ec;
    }

    public static EmergencyContactResponse toResponse(EmergencyContact ec) {
        if (ec == null) return null;
        EmergencyContactResponse r = new EmergencyContactResponse();
        r.setFullName(ec.getFullName());
        r.setRelationship(ec.getRelationship());
        r.setPhoneNumber(ec.getPhoneNumber());
        return r;
    }
}
