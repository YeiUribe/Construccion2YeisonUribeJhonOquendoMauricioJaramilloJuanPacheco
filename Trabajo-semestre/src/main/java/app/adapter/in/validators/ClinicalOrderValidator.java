package app.adapter.in.validators;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import app.domain.model.ClinicalOrder;
import app.domain.model.DiagnosticAid;
import app.domain.model.Medication;
import app.domain.model.Patient;
import app.domain.model.Procedure;
import app.domain.model.User;

@Component
public class ClinicalOrderValidator extends SimpleValidator {

    public long idValidator(String value) throws Exception {
        return longValidator("ID de la orden clínica", value);
    }

    public long longValidator(String fieldName, String value) throws Exception {
        
        return 0;
    }

    public Patient patientValidator(Patient patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }
        
        return patient;
    }

    public User doctorValidator(User doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("El doctor no puede ser nulo");
        }
       
        return doctor;
    }

    public LocalDate creationDateValidator(String value) throws Exception {
        return dateValidator("fecha de creación de la orden clínica", value);
    }

    public LocalDate dateValidator(String fieldName, String value) throws Exception {
        
        return LocalDate.now();
    }

    public List<Medication> medicationsValidator(List<Medication> medications) throws Exception {
        if (medications == null) {
            throw new Exception("La lista de medicamentos no puede ser nula");
        }
       
        return medications;
    }

    public List<Procedure> proceduresValidator(List<Procedure> procedures) throws Exception {
        if (procedures == null) {
            throw new Exception("La lista de procedimientos no puede ser nula");
        }
       
        return procedures;
    }

    public List<DiagnosticAid> diagnosticAidsValidator(List<DiagnosticAid> diagnosticAids) throws Exception {
        if (diagnosticAids == null) {
            throw new Exception("La lista de ayudas diagnósticas no puede ser nula");
        }
       
        return diagnosticAids;
    }

   
    public ClinicalOrder validateClinicalOrder(ClinicalOrder order) throws Exception {
        if (order == null) {
            throw new Exception("La orden clínica no puede ser nula");
        }
       
        order.setId(idValidator(String.valueOf(order.getId())));
        order.setPatient(patientValidator(order.getPatient()));
        order.setDoctor(doctorValidator(order.getDoctor()));
        order.setCreationDate(creationDateValidator(order.getCreationDate().toString()));
        order.setMedications(medicationsValidator(order.getMedications()));
        order.setProcedures(proceduresValidator(order.getProcedures()));
        order.setDiagnosticAids(diagnosticAidsValidator(order.getDiagnosticAids()));
        return order;
    }
}
