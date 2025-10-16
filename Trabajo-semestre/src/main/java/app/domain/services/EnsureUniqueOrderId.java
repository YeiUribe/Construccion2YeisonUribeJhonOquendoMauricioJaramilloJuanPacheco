package app.domain.services;

import app.domain.ports.ClinicalOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnsureUniqueOrderId {

    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public void execute(long orderId) {
        if (clinicalOrderPort.findById(orderId) != null) {
            throw new IllegalStateException("El ID de la orden clínica ya existe.");
        }
    }
}
