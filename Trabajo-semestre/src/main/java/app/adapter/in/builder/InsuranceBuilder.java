package app.adapter.in.builder;

import app.domain.model.Insurance;

public class InsuranceBuilder {
    private long id;
    private String companyName;
    private String contactNumber;
    private boolean active;

    public static InsuranceBuilder builder() {
        return new InsuranceBuilder();
    }

    public InsuranceBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public InsuranceBuilder withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public InsuranceBuilder withContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
        return this;
    }

    public InsuranceBuilder withActive(boolean active) {
        this.active = active;
        return this;
    }

    public Insurance build() {
        Insurance insurance = new Insurance();
        insurance.setId(id);
        insurance.setCompanyName(companyName);
        insurance.setContactNumber(contactNumber);
        insurance.setActive(active);
        return insurance;
    }
}