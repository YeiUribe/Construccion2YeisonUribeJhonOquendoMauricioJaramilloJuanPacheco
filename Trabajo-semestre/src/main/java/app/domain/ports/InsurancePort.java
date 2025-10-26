package app.domain.ports;

import app.domain.model.Insurance;

public interface InsurancePort {
    Insurance findById(Insurance insurance) throws Exception;
    Insurance findByCompany(Insurance insurance) throws Exception;
    void save(Insurance insurance) throws Exception;
}