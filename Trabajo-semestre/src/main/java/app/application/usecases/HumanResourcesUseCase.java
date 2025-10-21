package app.application.usecases;

import app.domain.services.CreateUser;
import app.domain.services.DeleteUser;
import app.domain.services.UpdateStaffInfo;
import app.domain.model.User;
import app.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HumanResourcesUseCase {
    @Autowired
    private CreateUser createUser;
    @Autowired
    private DeleteUser deleteUser;
    @Autowired
    private UpdateStaffInfo updateStaffInfo;

    public User hireStaff(User newStaffMember, Role role) {
        newStaffMember.setRole(role);
        return createUser.execute(newStaffMember);
    }
    
    public void terminateStaff(String documentNumber) {
        deleteUser.execute(documentNumber);
    }

    public User updateStaffInformation(User updatedUserData) {
        return updateStaffInfo.execute(updatedUserData);
    }
}
