package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateStaffInfo {

    @Autowired
    private UserPort userPort;

    public User execute(User updatedUserData) throws Exception {
        User existingUser = userPort.findByDocumentNumber(updatedUserData.getDocumentNumber());
        if (existingUser == null) {
            throw new IllegalStateException("Usuario a actualizar no encontrado.");
        }
        existingUser.setFullName(updatedUserData.getFullName());
        existingUser.setPhoneNumber(updatedUserData.getPhoneNumber());
        existingUser.setAddress(updatedUserData.getAddress());
        
        userPort.save(existingUser);
        return existingUser;
    }
}
