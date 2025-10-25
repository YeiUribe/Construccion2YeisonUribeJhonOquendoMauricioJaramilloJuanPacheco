package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.UserMapper;
import app.infrastructure.persistence.repository.UserRepository;
import java.util.Optional;

@Service
public class UserAdapter implements UserPort {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        return UserMapper.toDomain(savedEntity);
    }

    @Override
    public User findByDocumentNumber(String documentNumber) {
        long document = Long.parseLong(documentNumber);
        Optional<UserEntity> userEntity = userRepository.findByDocument(document);
        return userEntity.map(UserMapper::toDomain).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        Optional<UserEntity> userEntity = userRepository.findByUserName(username);
        return userEntity.map(UserMapper::toDomain).orElse(null);
    }

    @Override
    public boolean existsByUsername(String username) { // ✅ CORREGIDO: con 's'
        return userRepository.existsByUserName(username);
    }

    @Override
    public void deleteByDocumentNumber(String documentNumber) {
        long document = Long.parseLong(documentNumber);
        userRepository.deleteByDocument(document);
    }
}