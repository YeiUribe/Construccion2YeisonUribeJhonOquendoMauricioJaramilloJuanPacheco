package app.adapter.rest.mapper;

import app.adapter.rest.request.PatientRequest;
import app.adapter.rest.response.PatientResponse;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Patient;

/**
 * Mapper manual para Patient <-> DTO
 */
public class PatientMapper {

    public static PatientResponse toResponse(Patient p) {
        if (p == null) return null;
        PatientResponse r = new PatientResponse();
        r.setIdentificationNumber(p.getIdentificationNumber());
        r.setFullName(p.getFullName());
        r.setBirthDate(p.getBirthDate());
        r.setGender(p.getGender());
        r.setAddress(p.getAddress());
        r.setPhoneNumber(p.getPhoneNumber());
        r.setEmail(p.getEmail());

        EmergencyContact ec = p.getEmergencyContact();
        if (ec != null) {
            r.setEmergencyContactName(ec.getFullName());
            r.setEmergencyContactPhone(ec.getPhoneNumber());
            r.setEmergencyContactRelationship(ec.getRelationship());
        }

        Insurance ins = p.getInsurance();
        if (ins != null) {
            r.setInsuranceCompany(ins.getCompanyName());
            r.setInsurancePolicyNumber(String.valueOf(ins.getId()));
            r.setInsuranceActive(ins.isActive());
        }

        return r;
    }

    public static Patient fromRequest(PatientRequest req) {
        if (req == null) return null;
        Patient p = new Patient();
        p.setIdentificationNumber(req.getIdentificationNumber());
        p.setFullName(req.getFullName());
        p.setBirthDate(req.getBirthDate());
        p.setGender(req.getGender());
        p.setAddress(req.getAddress());
        p.setPhoneNumber(req.getPhoneNumber());
        p.setEmail(req.getEmail());

        if (req.getEcFullName() != null || req.getEcPhoneNumber() != null || req.getEcRelationship() != null) {
            EmergencyContact ec = new EmergencyContact();
            ec.setFullName(req.getEcFullName());
            ec.setPhoneNumber(req.getEcPhoneNumber());
            ec.setRelationship(req.getEcRelationship());
            p.setEmergencyContact(ec);
        }

        if (req.getInsuranceId() != null) {
            Insurance ins = new Insurance();
            try {
                long parsed = Long.parseLong(req.getInsuranceId());
                ins.setId(parsed);
            } catch (NumberFormatException ex) {
                // si no es numérico, se deja id 0; la información completa debe resolverse en la capa de servicio
            }
            p.setInsurance(ins);
        }

        return p;
    }
}
