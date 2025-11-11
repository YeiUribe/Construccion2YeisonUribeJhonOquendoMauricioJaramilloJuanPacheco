package app.domain.ports;

import app.domain.model.DiagnosticAid;
import java.util.List;

public interface DiagnosticAidPort {

    DiagnosticAid save(DiagnosticAid diagnosticAid);

    DiagnosticAid findById(long id);

    List<DiagnosticAid> findAll();
    
    DiagnosticAid findByName(String name);
}
