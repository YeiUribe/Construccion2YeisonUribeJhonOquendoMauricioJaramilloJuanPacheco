package app.domain.services;

import app.domain.model.ClinicalRecord;
import app.domain.ports.ClinicalRecordPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClinicalRecord {

    @Autowired
    private ClinicalRecordPort clinicalRecordPort;

    public ClinicalRecord execute(ClinicalRecord record) {
        return clinicalRecordPort.save(record);
    }
}
