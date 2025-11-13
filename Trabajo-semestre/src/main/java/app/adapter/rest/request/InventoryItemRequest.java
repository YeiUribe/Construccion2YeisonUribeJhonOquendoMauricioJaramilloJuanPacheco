package app.adapter.rest.request;

public class InventoryItemRequest {
    private String name;
    private double cost;

    public InventoryItemRequest() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
