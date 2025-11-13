package app.adapter.in.rest.controllers;

import app.adapter.rest.mapper.UserMapper;
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

    @PostMapping("/staff")
    public ResponseEntity<ApiResponse<UserResponse>> hireStaff(@RequestBody UserRequest request) {
        try {
            User user = UserMapper.fromRequest(request);
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
}