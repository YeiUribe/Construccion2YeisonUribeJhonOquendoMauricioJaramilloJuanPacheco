package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.DiagnosticAid;
import app.domain.model.Medication;
import app.domain.model.Procedure;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class ValidateOrderItemUniqueness {

    public void execute(ClinicalOrder order) {
        Set<Integer> itemNumbers = new HashSet<>();

        // Validar ítems de medicamentos
        if (order.getMedications() != null) {
            for (Medication med : order.getMedications()) {
                if (!itemNumbers.add(med.getItemNumber())) {
                    throw new IllegalStateException("Duplicate item number found: " + med.getItemNumber());
                }
            }
        }

        // Validar ítems de procedimientos
        if (order.getProcedures() != null) {
            for (Procedure proc : order.getProcedures()) {
                if (!itemNumbers.add(proc.getItemNumber())) {
                    throw new IllegalStateException("Número de ítem duplicado encontrado: " + proc.getItemNumber());
                }
            }
        }

        // Validar ítems de ayudas diagnósticas
        if (order.getDiagnosticAids() != null) {
            for (DiagnosticAid aid : order.getDiagnosticAids()) {
                if (!itemNumbers.add(aid.getItemNumber())) {
                    throw new IllegalStateException("Número de ítem duplicado encontrado: " + aid.getItemNumber());
                }
            }
        }
    }
}
