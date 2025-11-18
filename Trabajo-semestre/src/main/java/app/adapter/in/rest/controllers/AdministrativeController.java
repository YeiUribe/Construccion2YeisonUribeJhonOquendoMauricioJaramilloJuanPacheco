package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.PatientMapper;
import app.adapter.rest.mapper.InvoiceMapper;
import app.adapter.rest.request.InvoiceRequest;
import app.adapter.rest.request.PatientRequest;
import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.InvoiceResponse;
import app.adapter.rest.response.PatientResponse;
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
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/admin")
/**
 * Administrative endpoints.
 * Access: only users with role `ADMINISTRATIVE_STAFF` may call these endpoints.
 */
public class AdministrativeController {

    @Autowired
    private AdministrativeUseCase administrativeUseCase;

    @PostMapping("/patients")
    @PreAuthorize("hasRole('ADMINISTRATIVE_STAFF')")
    // Requires role: ADMINISTRATIVE_STAFF
    public ResponseEntity<ApiResponse<PatientResponse>> registerPatient(@RequestBody PatientRequest request) {
        try {
            Patient patient = PatientMapper.fromRequest(request);
            Patient newPatient = administrativeUseCase.registerNewPatient(patient);
            PatientResponse response = PatientMapper.toResponse(newPatient);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Paciente registrado exitosamente"));

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

    @PostMapping("/invoices")
    @PreAuthorize("hasRole('ADMINISTRATIVE_STAFF')")
    // Requires role: ADMINISTRATIVE_STAFF
    public ResponseEntity<ApiResponse<InvoiceResponse>> generateInvoice(@RequestBody InvoiceRequest request) {
        try {
            Invoice invoiceData = InvoiceMapper.toDomain(request);
            Invoice generatedInvoice = administrativeUseCase.generateInvoice(invoiceData);
            InvoiceResponse response = InvoiceMapper.toResponse(generatedInvoice);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Factura generada exitosamente"));

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