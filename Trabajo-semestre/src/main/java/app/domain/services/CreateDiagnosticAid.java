package app.domain.services;

import app.domain.model.DiagnosticAid;
import app.domain.ports.DiagnosticAidPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateDiagnosticAid {

    @Autowired
    private DiagnosticAidPort diagnosticAidPort;

    public DiagnosticAid execute(DiagnosticAid diagnosticAid) throws Exception {
       
        if (diagnosticAidPort.findByName(diagnosticAid.getName()) != null) {
            throw new IllegalStateException("Ya existe una ayuda diagnóstica con el nombre: " + diagnosticAid.getName());
        }
        diagnosticAidPort.save(diagnosticAid);
        return diagnosticAid;
    }
}
