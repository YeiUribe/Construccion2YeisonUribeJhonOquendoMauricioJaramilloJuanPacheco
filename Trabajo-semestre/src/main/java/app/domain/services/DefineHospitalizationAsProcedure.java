package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.Procedure;
import org.springframework.stereotype.Service;

@Service
public class DefineHospitalizationAsProcedure {

    public void execute(ClinicalOrder order, Procedure hospitalizationDetails) {
        if (hospitalizationDetails.getName().equalsIgnoreCase("Hospitalización")) {
            order.getProcedures().add(hospitalizationDetails);
        } else {
            throw new IllegalArgumentException("Este servicio es solo para procedimientos de hospitalización.");
        }
    }
}
