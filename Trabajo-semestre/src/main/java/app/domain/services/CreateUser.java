package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    @Autowired
    private UserPort userPort;

    public User execute(User user) {
        if (userPort.findByDocumentNumber(user.getDocumentNumber()) != null) {
            throw new IllegalStateException("El usuario con este número de documento ya existe.");
        }
        if (userPort.existsByUsername(user.getUsername())) {
            throw new IllegalStateException("El nombre de usuario ya existe.");
        }
        userPort.save(user);
        return user;
    }
}
