package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.PatientVitalsMapper;
import app.adapter.rest.request.VitalsRequest;
import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.PatientVitalsResponse;
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
@RequestMapping("/api/nurse")
public class NurseController {

    @Autowired
    private NurseUseCase nurseUseCase;

    @PostMapping("/vitals")
    public ResponseEntity<ApiResponse<PatientVitalsResponse>> recordVitals(@RequestBody VitalsRequest request) {
        try {
            PatientVitals vitals = PatientVitalsMapper.fromRequest(request);
            PatientVitals savedVitals = nurseUseCase.recordPatientVitals(vitals);
            PatientVitalsResponse response = PatientVitalsMapper.toResponse(savedVitals);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Vitales registrados exitosamente"));

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
}