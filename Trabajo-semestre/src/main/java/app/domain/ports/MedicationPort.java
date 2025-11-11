package app.domain.ports;

import app.domain.model.Medication;
import java.util.List;

public interface MedicationPort {

    void save(Medication medication) throws Exception;

    Medication findById(long id) throws Exception;

    List<Medication> findAll() throws Exception;
    
    Medication findByName(String name) throws Exception;
}
