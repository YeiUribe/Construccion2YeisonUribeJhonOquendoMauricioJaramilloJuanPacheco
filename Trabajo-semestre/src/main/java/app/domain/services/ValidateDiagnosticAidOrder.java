package app.domain.services;

import app.domain.model.ClinicalOrder;
import org.springframework.stereotype.Service;

@Service
public class ValidateDiagnosticAidOrder {

    public void execute(ClinicalOrder order) {
        boolean hasDiagnosticAid = order.getDiagnosticAids() != null && !order.getDiagnosticAids().isEmpty();
        boolean hasMedication = order.getMedications() != null && !order.getMedications().isEmpty();
        boolean hasProcedure = order.getProcedures() != null && !order.getProcedures().isEmpty();

        if (hasDiagnosticAid && (hasMedication || hasProcedure)) {
            throw new IllegalStateException("Una orden con ayuda diagnóstica no puede contener medicamentos ni procedimientos.");
        }
    }
}
