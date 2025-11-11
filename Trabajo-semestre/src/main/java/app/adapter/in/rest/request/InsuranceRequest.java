package app.adapter.in.rest.request;

public class InsuranceRequest {
    private String companyName;
    private String contactNumber;
    private boolean isActive; // Usamos boolean directamente

    // Getters y Setters
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }
}