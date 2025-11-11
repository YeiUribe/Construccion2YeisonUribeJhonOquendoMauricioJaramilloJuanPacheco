package app.adapter.in.rest.controllers;

import app.adapter.in.builder.PatientVitalsBuilder;
import app.adapter.in.rest.request.VitalsRequest;
import app.application.exceptions.InputsException;
import app.application.usecases.NurseUseCase;
import app.domain.model.PatientVitals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    @Autowired
    private NurseUseCase nurseUseCase;
    @Autowired
    private PatientVitalsBuilder patientVitalsBuilder;

    @PostMapping("/vitals")
    public ResponseEntity<?> recordVitals(@RequestBody VitalsRequest request) {
        try {
            PatientVitals vitals = patientVitalsBuilder.build(
                request.getPatientId(),
                request.getBloodPressure(),
                request.getTemperature(),
                request.getPulse(),
                request.getOxygenLevel()
            );

            PatientVitals savedVitals = nurseUseCase.recordPatientVitals(vitals);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVitals);

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}