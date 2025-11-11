package app.domain.ports;

import app.domain.model.DiagnosticAid;
import java.util.List;

public interface DiagnosticAidPort {

    void save(DiagnosticAid diagnosticAid) throws Exception;

    DiagnosticAid findById(long id) throws Exception;

    List<DiagnosticAid> findAll() throws Exception;
    
    DiagnosticAid findByName(String name) throws Exception;
}
