package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.ports.ClinicalOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClinicalOrder {

    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public ClinicalOrder execute(ClinicalOrder order) throws Exception {
        clinicalOrderPort.save(order);
        return order;
    }
}
