package app.adapter.in.builder;

import app.adapter.in.validators.UserValidator;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    @Autowired
    private UserValidator userValidator;

    public User build(String documentNumber, String fullName, String email, 
                      String phoneNumber, String birthDate, String address, 
                      String username, String password) throws Exception {
        
        User user = new User();
        user.setDocumentNumber(userValidator.documentValidator(documentNumber));
        user.setFullName(userValidator.stringValidator(fullName, password));
        user.setEmail(userValidator.emailValidator(email));
        user.setPhoneNumber(userValidator.phoneValidator(phoneNumber));
        user.setBirthDate(userValidator.dateValidator(birthDate));
        user.setAddress(userValidator.addressValidator(address));
        user.setUsername(userValidator.usernameValidator(username));
        user.setPassword(userValidator.passwordValidator(password));
        return user;
    }
}