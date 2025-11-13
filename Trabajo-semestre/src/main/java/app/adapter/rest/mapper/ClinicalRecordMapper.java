package app.adapter.rest.mapper;

import app.adapter.rest.request.ClinicalRecordRequest;
import app.adapter.rest.response.ClinicalRecordResponse;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;

public class ClinicalRecordMapper {

    public static ClinicalRecordResponse toResponse(ClinicalRecord c) {
        if (c == null) return null;
        ClinicalRecordResponse r = new ClinicalRecordResponse();
        r.setId(c.getId());
        Patient p = c.getPatient();
        if (p != null) {
            r.setPatientId(p.getIdentificationNumber());
            r.setPatientName(p.getFullName());
        }
        User d = c.getDoctor();
        if (d != null) {
            r.setDoctorId(d.getDocumentNumber());
            r.setDoctorName(d.getFullName());
        }
        r.setRecordDate(c.getRecordDate());
        r.setReasonForVisit(c.getReasonForVisit());
        r.setSymptoms(c.getSymptoms());
        r.setDiagnosis(c.getDiagnosis());
        return r;
    }

    public static ClinicalRecord fromRequest(ClinicalRecordRequest req) {
        if (req == null) return null;
        ClinicalRecord c = new ClinicalRecord();
        c.setRecordDate(req.getRecordDate());
        c.setReasonForVisit(req.getReasonForVisit());
        c.setSymptoms(req.getSymptoms());
        c.setDiagnosis(req.getDiagnosis());
        return c;
    }
}
