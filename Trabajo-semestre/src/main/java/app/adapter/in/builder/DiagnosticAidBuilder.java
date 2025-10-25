package app.adapter.in.builder;

import app.domain.model.DiagnosticAid;
import app.domain.model.enums.Specialty;

public class DiagnosticAidBuilder {
    private int itemNumber;
    private String name;
    private int quantity;
    private boolean requiresSpecialist;
    private Specialty specialty;
    private double cost;

    public static DiagnosticAidBuilder builder() {
        return new DiagnosticAidBuilder();
    }

    public DiagnosticAidBuilder withItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }

    public DiagnosticAidBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DiagnosticAidBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public DiagnosticAidBuilder withRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
        return this;
    }

    public DiagnosticAidBuilder withSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public DiagnosticAidBuilder withCost(double cost) {
        this.cost = cost;
        return this;
    }

    public DiagnosticAid build() {
        DiagnosticAid diagnosticAid = new DiagnosticAid();
        diagnosticAid.setItemNumber(itemNumber);
        diagnosticAid.setName(name);
        diagnosticAid.setQuantity(quantity);
        diagnosticAid.setRequiresSpecialist(requiresSpecialist);
        diagnosticAid.setSpecialty(specialty);
        diagnosticAid.setCost(cost);
        return diagnosticAid;
    }
}