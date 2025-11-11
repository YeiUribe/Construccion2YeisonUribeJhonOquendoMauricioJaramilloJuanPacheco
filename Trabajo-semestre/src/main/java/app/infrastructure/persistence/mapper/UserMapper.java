package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.infrastructure.persistence.entities.UserEntity;

public final class UserMapper {

    private UserMapper() {}

    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;
        UserEntity entity = new UserEntity();
        entity.setDocumentNumber(domain.getDocumentNumber());
        entity.setFullName(domain.getFullName());
        entity.setEmail(domain.getEmail());
        entity.setPhoneNumber(domain.getPhoneNumber());
        entity.setBirthDate(domain.getBirthDate());
        entity.setAddress(domain.getAddress());
        entity.setRole(domain.getRole());
        entity.setUsername(domain.getUsername());
        entity.setPassword(domain.getPassword());
        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;
        User domain = new User();
        domain.setDocumentNumber(entity.getDocumentNumber());
        domain.setFullName(entity.getFullName());
        domain.setEmail(entity.getEmail());
        domain.setPhoneNumber(entity.getPhoneNumber());
        domain.setBirthDate(entity.getBirthDate());
        domain.setAddress(entity.getAddress());
        domain.setRole(entity.getRole());
        domain.setUsername(entity.getUsername());
        domain.setPassword(entity.getPassword());
        return domain;
    }
}
