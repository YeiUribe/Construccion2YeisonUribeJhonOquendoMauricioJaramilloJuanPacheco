package app.adapter.rest.request;

public class DiagnosticAidRequest {
    private int itemNumber;
    private String name;
    private int quantity;
    private boolean requiresSpecialist;
    private String specialty; // enum name
    private double cost;

    public DiagnosticAidRequest() {}

    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int itemNumber) { this.itemNumber = itemNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isRequiresSpecialist() { return requiresSpecialist; }
    public void setRequiresSpecialist(boolean requiresSpecialist) { this.requiresSpecialist = requiresSpecialist; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
