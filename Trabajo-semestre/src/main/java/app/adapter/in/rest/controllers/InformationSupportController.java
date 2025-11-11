package app.adapter.in.rest.controllers;

import app.adapter.in.builder.InsuranceBuilder;
import app.adapter.in.builder.MedicationBuilder;
import app.adapter.in.builder.ProcedureBuilder;
import app.adapter.in.builder.DiagnosticAidBuilder;
import app.adapter.in.rest.request.InsuranceRequest;
import app.adapter.in.rest.request.InventoryItemRequest;
import app.application.exceptions.InputsException;
import app.application.usecases.InformationSupportUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/support")
public class InformationSupportController {

    @Autowired
    private InformationSupportUseCase informationSupportUseCase;
    
    @Autowired private MedicationBuilder medicationBuilder;
    @Autowired private ProcedureBuilder procedureBuilder;
    @Autowired private DiagnosticAidBuilder diagnosticAidBuilder;
    @Autowired private InsuranceBuilder insuranceBuilder;

    @PostMapping("/medications")
    public ResponseEntity<?> createMedication(@RequestBody InventoryItemRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                informationSupportUseCase.createMedication(
                    medicationBuilder.build(request.getName(), request.getCost())
                )
            );
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PostMapping("/procedures")
    public ResponseEntity<?> createProcedure(@RequestBody InventoryItemRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                informationSupportUseCase.createProcedure(
                    procedureBuilder.build(request.getName(), request.getCost())
                )
            );
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PostMapping("/diagnostic-aids")
    public ResponseEntity<?> createDiagnosticAid(@RequestBody InventoryItemRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(
                informationSupportUseCase.createDiagnosticAid(
                    diagnosticAidBuilder.build(request.getName(), request.getCost())
                )
            );
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    
    @PostMapping("/insurances")
    public ResponseEntity<?> createInsurance(@RequestBody InsuranceRequest request) {
        try {
             return ResponseEntity.status(HttpStatus.CREATED).body(
                 informationSupportUseCase.createInsurance(
                     insuranceBuilder.build(
                         request.getCompanyName(), 
                         request.getContactNumber(), 
                         String.valueOf(request.isActive()) // Convierte boolean a String para el builder
                     )
                 )
             );
        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}