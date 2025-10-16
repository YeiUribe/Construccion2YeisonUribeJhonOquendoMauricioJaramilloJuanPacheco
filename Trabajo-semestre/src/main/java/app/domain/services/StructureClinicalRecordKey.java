package app.domain.services;

import app.domain.model.ClinicalRecord;
import org.springframework.stereotype.Service;
import java.time.format.DateTimeFormatter;

@Service
public class StructureClinicalRecordKey {

    public String getPrimaryKey(ClinicalRecord record) {
        return record.getPatient().getIdentificationNumber();
    }

    public String getSecondaryKey(ClinicalRecord record) {
        return record.getRecordDate().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
