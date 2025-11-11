package app.adapter.in.rest.controllers;

import app.adapter.in.builder.UserBuilder;
import app.adapter.in.rest.request.UserRequest;
import app.application.exceptions.InputsException;
import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hr")
public class HumanResourcesController {

    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;
    @Autowired
    private UserBuilder userBuilder;

    @PostMapping("/staff")
    public ResponseEntity<?> hireStaff(@RequestBody UserRequest request) {
        try {
            User user = userBuilder.build(
                request.getDocumentNumber(),
                request.getFullName(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getBirthDate(),
                request.getAddress(),
                request.getUsername(),
                request.getPassword()
            );
            
            User createdUser = humanResourcesUseCase.hireStaff(user, request.getRole());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}