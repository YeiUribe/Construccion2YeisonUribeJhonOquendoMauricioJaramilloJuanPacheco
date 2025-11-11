package app.adapter.in.rest.controllers;

import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.rest.request.InvoiceRequest;
import app.adapter.in.rest.request.PatientRequest;
import app.application.exceptions.InputsException;
import app.application.usecases.AdministrativeUseCase;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdministrativeController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;
    @Autowired
    private PatientBuilder patientBuilder;
    @Autowired
    private InvoiceBuilder invoiceBuilder;

    @PostMapping("/patients")
    public ResponseEntity<?> registerPatient(@RequestBody PatientRequest request) {
        try {
            Patient patient = patientBuilder.build(
                request.getIdentificationNumber(),
                request.getFullName(),
                request.getBirthDate(),
                request.getGender(),
                request.getAddress(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getEcFullName(),
                request.getEcRelationship(),
                request.getEcPhoneNumber(),
                request.getInsuranceId()
            );

            Patient newPatient = administrativeUseCase.registerNewPatient(patient);
            return ResponseEntity.status(HttpStatus.CREATED).body(newPatient);

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalStateException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/invoices")
    public ResponseEntity<?> generateInvoice(@RequestBody InvoiceRequest request) {
        try {
            Invoice invoiceData = invoiceBuilder.build(
                request.getPatientId(),
                request.getDoctorId()
            );
            
            Invoice generatedInvoice = administrativeUseCase.generateInvoice(invoiceData);
            return ResponseEntity.status(HttpStatus.CREATED).body(generatedInvoice);

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalStateException e) { 
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}