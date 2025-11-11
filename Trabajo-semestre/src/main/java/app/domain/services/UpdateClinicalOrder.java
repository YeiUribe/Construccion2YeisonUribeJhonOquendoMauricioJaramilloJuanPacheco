package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.ports.ClinicalOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClinicalOrder {

    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public ClinicalOrder execute(ClinicalOrder order) {
        if (clinicalOrderPort.findById(order.getId()) == null) {
            throw new IllegalStateException("Cannot update an order that does not exist.");
        }
        clinicalOrderPort.save(order);
        return order;
    }
}