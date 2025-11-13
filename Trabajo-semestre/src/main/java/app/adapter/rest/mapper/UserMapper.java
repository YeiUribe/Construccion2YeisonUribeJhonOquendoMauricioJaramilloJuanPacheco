package app.adapter.rest.mapper;

import app.adapter.rest.response.UserResponse;
import app.adapter.rest.request.UserRequest;
import app.domain.model.User;

/**
 * Mapper manual para User <-> DTO
 */
public class UserMapper {

    public static UserResponse toResponse(User u) {
        if (u == null) return null;
        UserResponse r = new UserResponse();
        r.setDocumentNumber(u.getDocumentNumber());
        r.setFullName(u.getFullName());
        r.setEmail(u.getEmail());
        r.setPhoneNumber(u.getPhoneNumber());
        r.setBirthDate(u.getBirthDate());
        r.setAddress(u.getAddress());
        r.setUsername(u.getUsername());
        if (u.getRole() != null) r.setRole(u.getRole().name());
        return r;
    }

    public static User fromRequest(UserRequest req) {
        if (req == null) return null;
        User u = new User();
        u.setDocumentNumber(req.getDocumentNumber());
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPhoneNumber(req.getPhoneNumber());
        // birthDate in request is String in current Request; conversion required in service layer
        u.setAddress(req.getAddress());
        u.setUsername(req.getUsername());
        u.setPassword(req.getPassword());
        u.setRole(req.getRole());
        return u;
    }
}
