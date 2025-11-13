package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.MedicationMapper;
import app.adapter.rest.mapper.ProcedureMapper;
import app.adapter.rest.mapper.DiagnosticAidMapper;
import app.adapter.rest.mapper.InsuranceMapper;
import app.adapter.rest.request.InsuranceRequest;
import app.adapter.rest.request.InventoryItemRequest;
import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.DiagnosticAidResponse;
import app.adapter.rest.response.InsuranceResponse;
import app.adapter.rest.response.MedicationResponse;
import app.adapter.rest.response.ProcedureResponse;
import app.application.exceptions.InputsException;
import app.application.usecases.InformationSupportUseCase;
import app.domain.model.DiagnosticAid;
import app.domain.model.Insurance;
import app.domain.model.Medication;
import app.domain.model.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/support")
public class InformationSupportController {

    @Autowired
    private InformationSupportUseCase informationSupportUseCase;

    @PostMapping("/medications")
    public ResponseEntity<ApiResponse<MedicationResponse>> createMedication(@RequestBody InventoryItemRequest request) {
        try {
            Medication med = MedicationMapper.toDomain(request);
            Medication created = informationSupportUseCase.createMedication(med);
            MedicationResponse response = MedicationMapper.toResponse(created);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Medicamento creado exitosamente"));
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
    
    @PostMapping("/procedures")
    public ResponseEntity<ApiResponse<ProcedureResponse>> createProcedure(@RequestBody InventoryItemRequest request) {
        try {
            Procedure proc = ProcedureMapper.toDomain(request);
            Procedure created = informationSupportUseCase.createProcedure(proc);
            ProcedureResponse response = ProcedureMapper.toResponse(created);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Procedimiento creado exitosamente"));
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
    
    @PostMapping("/diagnostic-aids")
    public ResponseEntity<ApiResponse<DiagnosticAidResponse>> createDiagnosticAid(@RequestBody InventoryItemRequest request) {
        try {
            DiagnosticAid aid = DiagnosticAidMapper.toDomain(request);
            DiagnosticAid created = informationSupportUseCase.createDiagnosticAid(aid);
            DiagnosticAidResponse response = DiagnosticAidMapper.toResponse(created);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Ayuda diagnóstica creada exitosamente"));
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
    
    @PostMapping("/insurances")
    public ResponseEntity<ApiResponse<InsuranceResponse>> createInsurance(@RequestBody InsuranceRequest request) {
        try {
            Insurance insurance = InsuranceMapper.fromRequest(request);
            Insurance created = informationSupportUseCase.createInsurance(insurance);
            InsuranceResponse response = InsuranceMapper.toResponse(created);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Seguro creado exitosamente"));
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }
}