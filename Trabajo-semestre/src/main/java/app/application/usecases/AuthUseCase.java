package app.application.usecases;

import app.adapter.rest.response.LoginResponse;
import app.domain.model.User;
import app.domain.ports.UserPort;
import app.infrastructure.security.JwtAdapter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthUseCase {
    @Autowired
    private UserPort userPort;
    @Autowired
    private JwtAdapter jwtAdapter;
    @Autowired
    private AuthenticationManager authenticationManager;

    public LoginResponse login(String username, String password) throws Exception {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        // load user to get role
        User user = userPort.findByUsername(username);
        if (user == null) throw new IllegalArgumentException("Usuario no encontrado");
        List<String> roles = List.of(user.getRole().name());
        String token = jwtAdapter.generateToken(user.getUsername(), roles);
        long expiresIn = jwtAdapter.getExpirationMillis();
        return new LoginResponse(token, expiresIn);
    }
}
