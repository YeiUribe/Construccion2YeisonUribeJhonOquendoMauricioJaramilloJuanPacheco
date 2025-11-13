package app.adapter.rest.response;

public class InsuranceResponse {
    private long id;
    private String companyName;
    private String contactNumber;
    private boolean active;

    public InsuranceResponse() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
