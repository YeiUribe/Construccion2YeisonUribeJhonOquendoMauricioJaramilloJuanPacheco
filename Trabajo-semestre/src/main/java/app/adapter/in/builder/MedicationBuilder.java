package app.adapter.in.builder;

import app.domain.model.Medication;

public class MedicationBuilder {
    private long orderId;
    private int itemNumber;
    private String name;
    private String dosage;
    private String duration;
    private double cost;

    public static MedicationBuilder builder() {
        return new MedicationBuilder();
    }

    public MedicationBuilder withOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public MedicationBuilder withItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }

    public MedicationBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MedicationBuilder withDosage(String dosage) {
        this.dosage = dosage;
        return this;
    }

    public MedicationBuilder withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public MedicationBuilder withCost(double cost) {
        this.cost = cost;
        return this;
    }

    public Medication build() {
        Medication medication = new Medication();
        medication.setOrderId(orderId);
        medication.setItemNumber(itemNumber);
        medication.setName(name);
        medication.setDosage(dosage);
        medication.setDuration(duration);
        medication.setCost(cost);
        return medication;
    }
}