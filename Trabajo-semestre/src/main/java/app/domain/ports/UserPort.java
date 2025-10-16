package app.domain.ports;

import app.domain.model.User;

public interface UserPort {

    User save(User user);

    User findByDocumentNumber(String documentNumber);

    User findByUsername(String username);

    boolean existsByUsername(String username);
}
