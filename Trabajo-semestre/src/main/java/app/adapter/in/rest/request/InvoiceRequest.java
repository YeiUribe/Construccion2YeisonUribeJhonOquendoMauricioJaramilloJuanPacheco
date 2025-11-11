package app.adapter.in.rest.request;

public class InvoiceRequest {
    private String patientId;
    private String doctorId;

    public String getPatientId() { 
        return patientId; 
    }
    public void setPatientId(String patientId) { 
        this.patientId = patientId; 
    }
    
    // --- ESTE ES EL MÉTODO QUE FALTA ---
    public String getDoctorId() { 
        return doctorId; 
    }
    public void setDoctorId(String doctorId) { 
        this.doctorId = doctorId; 
    }
}