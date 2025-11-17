package app.adapter.in.rest.controllers;

import app.adapter.rest.request.LoginRequest;
import app.adapter.rest.response.ApiResponse;
import app.adapter.rest.response.LoginResponse;
import app.application.usecases.AuthUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthUseCase authUseCase;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = authUseCase.login(request.getUsername(), request.getPassword());
            return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.ok(response, "Login exitoso"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ApiResponse.error("Credenciales inválidas", null));
        }
    }
}
