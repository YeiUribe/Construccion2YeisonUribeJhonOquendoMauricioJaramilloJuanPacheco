package app.adapter.in.builder;

import app.adapter.validators.InsuranceValidator;
import app.domain.model.Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsuranceBuilder {

    @Autowired
    private InsuranceValidator insuranceValidator;

    public Insurance build(String companyName, String contactNumber, String isActive) throws Exception {
        Insurance insurance = new Insurance();
        insurance.setCompanyName(insuranceValidator.stringValidator(companyName));
        insurance.setContactNumber(insuranceValidator.phoneValidator(contactNumber));
        insurance.setActive(insuranceValidator.booleanValidator(isActive));
        return insurance;
    }
}