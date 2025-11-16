package app.adapter.rest.mapper;

import app.adapter.rest.request.PatientVitalsRequest;
import app.adapter.rest.request.VitalsRequest;
import app.adapter.rest.response.PatientVitalsResponse;
import app.domain.model.PatientVitals;
import app.domain.model.Patient;

public class PatientVitalsMapper {

    public static PatientVitals toDomain(PatientVitalsRequest req) {
        if (req == null) return null;
        PatientVitals v = new PatientVitals();
        v.setRecordTimestamp(req.getRecordTimestamp());
        v.setBloodPressure(req.getBloodPressure());
        v.setTemperature(req.getTemperature());
        v.setPulse(req.getPulse());
        v.setOxygenLevel(req.getOxygenLevel());
        return v;
    }

    public static PatientVitals fromRequest(VitalsRequest req) {
        if (req == null) return null;
        PatientVitals v = new PatientVitals();
        
        // Crear Patient con identificationNumber
        if (req.getPatientId() != null) {
            Patient p = new Patient();
            p.setIdentificationNumber(req.getPatientId());
            v.setPatient(p);
        }
        
        v.setRecordTimestamp(req.getRecordTimestamp());
        v.setBloodPressure(req.getBloodPressure());
        v.setTemperature(req.getTemperature());
        v.setPulse(req.getPulse());
        v.setOxygenLevel(req.getOxygenLevel());
        return v;
    }

    public static PatientVitalsResponse toResponse(PatientVitals v) {
        if (v == null) return null;
        PatientVitalsResponse r = new PatientVitalsResponse();
        r.setId(v.getId());
        Patient p = v.getPatient();
        if (p != null) r.setPatientId(p.getIdentificationNumber());
        r.setRecordTimestamp(v.getRecordTimestamp());
        r.setBloodPressure(v.getBloodPressure());
        r.setTemperature(v.getTemperature());
        r.setPulse(v.getPulse());
        r.setOxygenLevel(v.getOxygenLevel());
        return r;
    }
}
