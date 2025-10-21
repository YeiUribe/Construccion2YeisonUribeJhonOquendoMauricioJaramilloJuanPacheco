package app.application.usecases;

import app.domain.model.DiagnosticAid;
import app.domain.model.Medication;
import app.domain.model.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InformationSupportUseCase {

    public Medication createMedication(Medication medication) {
        return medication;
    }

    public Procedure createProcedure(Procedure procedure) {
        return procedure;
    }
    
    public DiagnosticAid createDiagnosticAid(DiagnosticAid diagnosticAid) {
        return diagnosticAid;
    }
}