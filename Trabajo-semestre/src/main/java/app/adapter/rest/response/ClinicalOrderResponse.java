package app.adapter.rest.response;

import java.time.LocalDate;
import java.util.List;

public class ClinicalOrderResponse {
    private long id;
    private String patientId;
    private String patientName;
    private String doctorId;
    private String doctorName;
    private LocalDate creationDate;
    private List<MedicationResponse> medications;
    private List<ProcedureResponse> procedures;
    private List<DiagnosticAidResponse> diagnosticAids;

    public ClinicalOrderResponse() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public LocalDate getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDate creationDate) { this.creationDate = creationDate; }

    public List<MedicationResponse> getMedications() { return medications; }
    public void setMedications(List<MedicationResponse> medications) { this.medications = medications; }

    public List<ProcedureResponse> getProcedures() { return procedures; }
    public void setProcedures(List<ProcedureResponse> procedures) { this.procedures = procedures; }

    public List<DiagnosticAidResponse> getDiagnosticAids() { return diagnosticAids; }
    public void setDiagnosticAids(List<DiagnosticAidResponse> diagnosticAids) { this.diagnosticAids = diagnosticAids; }
}
