package app.application.usecases;

import app.domain.services.CreateDiagnosticAid;
import app.domain.services.CreateInsurance;
import app.domain.services.CreateMedication;
import app.domain.services.CreateProcedure;
import app.domain.model.DiagnosticAid;
import app.domain.model.Insurance;
import app.domain.model.Medication;
import app.domain.model.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformationSupportUseCase {

    @Autowired
    private CreateMedication createMedication;
    
    @Autowired
    private CreateProcedure createProcedure;
    
    @Autowired
    private CreateDiagnosticAid createDiagnosticAid;
    
    @Autowired
    private CreateInsurance createInsurance; // <-- 1. Añade esta inyección

    public Medication createMedication(Medication medication) {
        return createMedication.execute(medication);
    }

    public Procedure createProcedure(Procedure procedure) {
        return createProcedure.execute(procedure);
    }
    
    public DiagnosticAid createDiagnosticAid(DiagnosticAid diagnosticAid) {
        return createDiagnosticAid.execute(diagnosticAid);
    }
    
    // --- 2. Añade este método ---
    public Insurance createInsurance(Insurance insurance) {
        return createInsurance.execute(insurance);
    }
}