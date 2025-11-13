package app.adapter.rest.request;

public class MedicationRequest {
    private int itemNumber;
    private String name;
    private String dosage;
    private String duration;
    private double cost;

    public MedicationRequest() {}

    public int getItemNumber() { return itemNumber; }
    public void setItemNumber(int itemNumber) { this.itemNumber = itemNumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDosage() { return dosage; }
    public void setDosage(String dosage) { this.dosage = dosage; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
