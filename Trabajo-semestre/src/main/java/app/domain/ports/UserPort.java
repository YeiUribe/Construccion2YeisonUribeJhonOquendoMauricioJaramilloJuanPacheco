package app.domain.ports;

import app.domain.model.User;

public interface UserPort {

    void save(User user);

    User findByDocumentNumber(String documentNumber);

    User findByUsername(String username);

    boolean existsByUsername(String username);
    
    void deleteByDocumentNumber(String documentNumber);
}
