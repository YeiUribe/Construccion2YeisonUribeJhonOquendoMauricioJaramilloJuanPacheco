package app.domain.services;

import app.domain.model.User;
import app.domain.model.enums.Role;
import org.springframework.stereotype.Service;

@Service
public class UserDataAccessControl {

    public boolean canViewClinicalInfo(User user) {
        return user.getRole() != Role.HUMAN_RESOURCES;
    }
}
