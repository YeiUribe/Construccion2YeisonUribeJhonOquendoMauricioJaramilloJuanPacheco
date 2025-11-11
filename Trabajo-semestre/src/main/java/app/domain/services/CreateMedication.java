package app.domain.services;

import app.domain.model.Medication;
import app.domain.ports.MedicationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMedication {

    @Autowired
    private MedicationPort medicationPort;

    public Medication execute(Medication medication) throws Exception {
        if (medicationPort.findByName(medication.getName()) != null) {
            throw new IllegalStateException("Ya existe un medicamento con el nombre: " + medication.getName());
        }
        medicationPort.save(medication);
        return medication;
    }
}