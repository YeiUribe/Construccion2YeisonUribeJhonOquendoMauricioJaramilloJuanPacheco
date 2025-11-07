package app.adapter.in.builder;

import app.adapter.in.validators.DiagnosticAidValidator;
import app.domain.model.DiagnosticAid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticAidBuilder {

    @Autowired
    private DiagnosticAidValidator diagnosticAidValidator;

    public DiagnosticAid build(String name, String cost) throws Exception {
        DiagnosticAid diagnosticAid = new DiagnosticAid();
        diagnosticAid.setName(diagnosticAidValidator.stringValidator(name));
        diagnosticAid.setCost(diagnosticAidValidator.doubleValidator(cost));
        return diagnosticAid;
    }
}