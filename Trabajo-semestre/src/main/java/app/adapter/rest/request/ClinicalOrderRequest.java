package app.adapter.rest.request;

import java.time.LocalDate;
import java.util.List;

public class ClinicalOrderRequest {
    private Long patientId;
    private Long doctorId;
    private LocalDate creationDate;
    private List<MedicationRequest> medications;
    private List<ProcedureRequest> procedures;
    private List<DiagnosticAidRequest> diagnosticAids;

    public ClinicalOrderRequest() {}

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }

    public Long getDoctorId() { return doctorId; }
    public void setDoctorId(Long doctorId) { this.doctorId = doctorId; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public List<MedicationRequest> getMedications() { return medications; }
    public void setMedications(List<MedicationRequest> medications) { this.medications = medications; }

    public List<ProcedureRequest> getProcedures() { return procedures; }
    public void setProcedures(List<ProcedureRequest> procedures) { this.procedures = procedures; }

    public List<DiagnosticAidRequest> getDiagnosticAids() { return diagnosticAids; }
    public void setDiagnosticAids(List<DiagnosticAidRequest> diagnosticAids) { this.diagnosticAids = diagnosticAids; }
}
