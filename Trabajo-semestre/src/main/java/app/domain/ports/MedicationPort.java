package app.domain.ports;

import app.domain.model.Medication;
import java.util.List;

public interface MedicationPort {

    Medication save(Medication medication);

    Medication findById(long id);

    List<Medication> findAll();
}
