package app.application.usecases;

import app.domain.services.RecordVitals;
import app.domain.model.PatientVitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NurseUseCase {

    @Autowired
    private RecordVitals recordVitals;

    public PatientVitals recordPatientVitals(PatientVitals vitals) {
        return recordVitals.execute(vitals);
    }
}
