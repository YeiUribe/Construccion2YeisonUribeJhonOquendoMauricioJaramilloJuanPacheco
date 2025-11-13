package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.ClinicalOrderMapper;
import app.adapter.rest.mapper.ClinicalRecordMapper;
import app.adapter.rest.request.ClinicalOrderRequest;
import app.adapter.rest.request.ClinicalRecordRequest;
import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.ClinicalOrderResponse;
import app.adapter.rest.response.ClinicalRecordResponse;
import app.application.exceptions.InputsException;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorUseCase doctorUseCase;

    @PostMapping("/clinical-records")
    public ResponseEntity<ApiResponse<ClinicalRecordResponse>> createRecord(@RequestBody ClinicalRecordRequest request) {
        try {
            ClinicalRecord record = ClinicalRecordMapper.fromRequest(request);
            ClinicalRecord newRecord = doctorUseCase.createNewClinicalRecord(record, null);
            ClinicalRecordResponse response = ClinicalRecordMapper.toResponse(newRecord);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Registro clínico creado exitosamente"));

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (IllegalStateException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
    
    @PostMapping("/clinical-orders")
    public ResponseEntity<ApiResponse<ClinicalOrderResponse>> createOrder(@RequestBody ClinicalOrderRequest request) {
        try {
            ClinicalOrder order = ClinicalOrderMapper.fromRequest(request);
            ClinicalOrder newOrder = doctorUseCase.createNewClinicalOrder(order);
            ClinicalOrderResponse response = ClinicalOrderMapper.toResponse(newOrder);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Orden clínica creada exitosamente"));

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (IllegalStateException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
}