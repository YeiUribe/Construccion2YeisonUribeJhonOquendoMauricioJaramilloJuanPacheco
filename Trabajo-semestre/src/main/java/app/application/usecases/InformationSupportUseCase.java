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
    private CreateInsurance createInsurance; 

    public Medication createMedication(Medication medication) throws Exception {
        return createMedication.execute(medication);
    }

    public Procedure createProcedure(Procedure procedure) throws Exception {
        return createProcedure.execute(procedure);
    }
    
    public DiagnosticAid createDiagnosticAid(DiagnosticAid diagnosticAid) throws Exception {
        return createDiagnosticAid.execute(diagnosticAid);
    }
    

    public Insurance createInsurance(Insurance insurance) throws Exception {
        return createInsurance.execute(insurance);
    }
}