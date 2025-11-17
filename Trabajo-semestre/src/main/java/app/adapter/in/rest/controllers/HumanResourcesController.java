package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.UserMapper;
import app.adapter.in.validators.UserValidator;
import java.time.LocalDate;
import app.adapter.rest.request.UserRequest;
import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.UserResponse;
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
@RequestMapping("/api/hr")
public class HumanResourcesController {

    @Autowired
    private HumanResourcesUseCase humanResourcesUseCase;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/staff")
    public ResponseEntity<ApiResponse<UserResponse>> hireStaff(@RequestBody UserRequest request) {
        try {
            // Validar campos de entrada antes de mapear al dominio
            String documentNumber = userValidator.documentValidator(request.getDocumentNumber());
            String fullName = userValidator.nameValidator(request.getFullName());
            String email = userValidator.emailValidator(request.getEmail());
            String phone = null;
            if (request.getPhoneNumber() != null) phone = userValidator.phoneValidator(request.getPhoneNumber());
            LocalDate birthDate = null;
            if (request.getBirthDate() != null) birthDate = userValidator.dateValidator(request.getBirthDate());
            String address = null;
            if (request.getAddress() != null) address = userValidator.addressValidator(request.getAddress());
            String username = userValidator.usernameValidator(request.getUsername());
            String password = userValidator.passwordValidator(request.getPassword());

            User user = new User();
            user.setDocumentNumber(documentNumber);
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPhoneNumber(phone);
            user.setBirthDate(birthDate);
            user.setAddress(address);
            user.setUsername(username);
            user.setPassword(password);

            User createdUser = humanResourcesUseCase.hireStaff(user, request.getRole());
            UserResponse response = UserMapper.toResponse(createdUser);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(response, "Personal contratado exitosamente"));

        } catch (InputsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(ApiResponse.error(e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.error("Error interno del servidor", null));
        }
    }

        @PostMapping("/staff/update")
        @org.springframework.security.access.prepost.PreAuthorize("hasRole('ADMINISTRATIVE_STAFF') or hasRole('HUMAN_RESOURCES')")
        public ResponseEntity<ApiResponse<UserResponse>> updateStaff(@RequestBody UserRequest request) {
            try {
                // Validar campos igual que en hireStaff
                String documentNumber = userValidator.documentValidator(request.getDocumentNumber());
                String fullName = userValidator.nameValidator(request.getFullName());
                String phone = null;
                if (request.getPhoneNumber() != null) phone = userValidator.phoneValidator(request.getPhoneNumber());
                String address = null;
                if (request.getAddress() != null) address = userValidator.addressValidator(request.getAddress());

                User user = new User();
                user.setDocumentNumber(documentNumber);
                user.setFullName(fullName);
                user.setPhoneNumber(phone);
                user.setAddress(address);

                User updatedUser = humanResourcesUseCase.updateStaffInformation(user);
                UserResponse response = UserMapper.toResponse(updatedUser);
                return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.ok(response, "Personal actualizado exitosamente"));
            } catch (InputsException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage(), null));
            } catch (IllegalStateException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage(), null));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error interno del servidor", null));
            }
        }

        @PostMapping("/staff/delete")
        @org.springframework.security.access.prepost.PreAuthorize("hasRole('ADMINISTRATIVE_STAFF')")
        public ResponseEntity<ApiResponse<Void>> deleteStaff(@RequestBody UserRequest request) {
            try {
                String documentNumber = userValidator.documentValidator(request.getDocumentNumber());
                humanResourcesUseCase.terminateStaff(documentNumber);
                return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.ok(null, "Personal eliminado exitosamente"));
            } catch (InputsException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.error(e.getMessage(), null));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error("Error interno del servidor", null));
            }
        }
}