package app.domain.services;

import app.domain.model.Insurance;
import app.domain.ports.InsurancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateInsurance {

    @Autowired
    private InsurancePort insurancePort;

    public Insurance execute(Insurance insurance) throws Exception { 
        if (insurancePort.findByCompanyName(insurance.getCompanyName()) != null) {
            throw new IllegalStateException("Ya existe una aseguradora con el nombre: " + insurance.getCompanyName());
        }
        return insurancePort.save(insurance);
    }
}