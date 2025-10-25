package app.adapter.in.builder;

import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;
import java.time.LocalDate;

public class InvoiceBuilder {
    private long id;
    private LocalDate issueDate;
    private Patient patient;
    private User doctor;
    private double totalAmount;
    private double copayAmount;

    public static InvoiceBuilder builder() {
        return new InvoiceBuilder();
    }

    public InvoiceBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public InvoiceBuilder withIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public InvoiceBuilder withPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public InvoiceBuilder withDoctor(User doctor) {
        this.doctor = doctor;
        return this;
    }

    public InvoiceBuilder withTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
        return this;
    }

    public InvoiceBuilder withCopayAmount(double copayAmount) {
        this.copayAmount = copayAmount;
        return this;
    }

    public Invoice build() {
        Invoice invoice = new Invoice();
        invoice.setId(id);
        invoice.setIssueDate(issueDate);
        invoice.setPatient(patient);
        invoice.setDoctor(doctor);
        invoice.setTotalAmount(totalAmount);
        invoice.setCopayAmount(copayAmount);
        return invoice;
    }
}