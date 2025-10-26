package app.domain.ports;

import app.domain.model.EmergencyContact;

public interface EmergencyContactPort {

    EmergencyContact findById(EmergencyContact contact) throws Exception;

    EmergencyContact findByPhone(EmergencyContact contact) throws Exception;

    void save(EmergencyContact contact) throws Exception;
}

