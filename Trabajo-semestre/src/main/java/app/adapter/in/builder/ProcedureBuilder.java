package app.adapter.in.builder;

import app.domain.model.Procedure;
import app.domain.model.enums.Specialty;

public class ProcedureBuilder {
    private int itemNumber;
    private String name;
    private int repetitionCount;
    private String frequency;
    private boolean requiresSpecialist;
    private Specialty specialty;
    private double cost;

    public static ProcedureBuilder builder() {
        return new ProcedureBuilder();
    }

    public ProcedureBuilder withItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
        return this;
    }

    public ProcedureBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProcedureBuilder withRepetitionCount(int repetitionCount) {
        this.repetitionCount = repetitionCount;
        return this;
    }

    public ProcedureBuilder withFrequency(String frequency) {
        this.frequency = frequency;
        return this;
    }

    public ProcedureBuilder withRequiresSpecialist(boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
        return this;
    }

    public ProcedureBuilder withSpecialty(Specialty specialty) {
        this.specialty = specialty;
        return this;
    }

    public ProcedureBuilder withCost(double cost) {
        this.cost = cost;
        return this;
    }

    public Procedure build() {
        Procedure procedure = new Procedure();
        procedure.setItemNumber(itemNumber);
        procedure.setName(name);
        procedure.setRepetitionCount(repetitionCount);
        procedure.setFrequency(frequency);
        procedure.setRequiresSpecialist(requiresSpecialist);
        procedure.setSpecialty(specialty);
        procedure.setCost(cost);
        return procedure;
    }
}