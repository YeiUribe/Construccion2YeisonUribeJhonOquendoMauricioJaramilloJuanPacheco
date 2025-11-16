package app.adapter.rest.request;

import java.time.LocalDate;
import java.util.List;

public class ClinicalOrderRequest {
    private String patientId;   // identificationNumber (String)
    private String doctorId;    // documentNumber (String)
    private LocalDate creationDate;
    private List<MedicationRequest> medications;
    private List<ProcedureRequest> procedures;
    private List<DiagnosticAidRequest> diagnosticAids;

    public ClinicalOrderRequest() {}

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public List<MedicationRequest> getMedications() { return medications; }
    public void setMedications(List<MedicationRequest> medications) { this.medications = medications; }

    public List<ProcedureRequest> getProcedures() { return procedures; }
    public void setProcedures(List<ProcedureRequest> procedures) { this.procedures = procedures; }

    public List<DiagnosticAidRequest> getDiagnosticAids() { return diagnosticAids; }
    public void setDiagnosticAids(List<DiagnosticAidRequest> diagnosticAids) { this.diagnosticAids = diagnosticAids; }
}
