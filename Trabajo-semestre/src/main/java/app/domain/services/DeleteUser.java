package app.domain.services;

import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUser {

    @Autowired
    private UserPort userPort;

    public void execute(String documentNumber) {
        // userPort.deleteByDocumentNumber(documentNumber);
    }
}
