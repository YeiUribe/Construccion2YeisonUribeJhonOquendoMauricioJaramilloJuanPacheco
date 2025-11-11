package app.adapter.in.rest.controllers;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.adapter.in.rest.request.ClinicalOrderRequest;
import app.adapter.in.rest.request.ClinicalRecordRequest;
import app.application.exceptions.InputsException;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.PatientVitals;
// import app.application.service.FindVitals; // Se asume un servicio para buscar vitales
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorUseCase doctorUseCase;
    @Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;
    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;
    // @Autowired
    // private FindVitals findVitals; 

    @PostMapping("/clinical-records")
    public ResponseEntity<?> createRecord(@RequestBody ClinicalRecordRequest request) {
        try {
            ClinicalRecord record = clinicalRecordBuilder.build(
                request.getPatientId(),
                request.getDoctorId(),
                request.getReasonForVisit(),
                request.getSymptoms(),
                request.getDiagnosis()
            );
            
            PatientVitals vitals = null; // Simulado
            // PatientVitals vitals = findVitals.execute(request.getVitalsId());

            ClinicalRecord newRecord = doctorUseCase.createNewClinicalRecord(record, vitals);
            return ResponseEntity.status(HttpStatus.CREATED).body(newRecord);

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalStateException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PostMapping("/clinical-orders")
    public ResponseEntity<?> createOrder(@RequestBody ClinicalOrderRequest request) {
        try {
            ClinicalOrder order = clinicalOrderBuilder.build(
                request.getPatientId(),
                request.getDoctorId()
            );
            
            ClinicalOrder newOrder = doctorUseCase.createNewClinicalOrder(order);
            return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalStateException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}