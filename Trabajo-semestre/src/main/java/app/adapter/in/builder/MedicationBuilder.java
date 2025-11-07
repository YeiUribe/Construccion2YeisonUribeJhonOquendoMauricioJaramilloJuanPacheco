package app.adapter.in.builder;

import app.adapter.in.validators.MedicationValidator;
import app.domain.model.Medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicationBuilder {

    @Autowired
    private MedicationValidator medicationValidator;

    public Medication build(String name, String cost) throws Exception {
        Medication medication = new Medication();
        medication.setName(medicationValidator.stringValidator(name));
        medication.setCost(medicationValidator.doubleValidator(cost));
        return medication;
    }
}