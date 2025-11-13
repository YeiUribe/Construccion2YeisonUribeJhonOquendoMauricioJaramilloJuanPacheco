package app.adapter.rest.request;

public class InsuranceRequest {
    private String companyName;
    private String contactNumber;
    private boolean active;

    public InsuranceRequest() {}

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
