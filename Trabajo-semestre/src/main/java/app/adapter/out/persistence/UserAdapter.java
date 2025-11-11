package app.adapter.out.persistence;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.UserMapper;
import app.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter implements UserPort {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) throws Exception {
        UserEntity entity = UserMapper.toEntity(user);
        userRepository.save(entity);
    }

    @Override
    public User findByDocumentNumber(String documentNumber) throws Exception {
        UserEntity entity = userRepository.findByDocumentNumber(documentNumber);
        return UserMapper.toDomain(entity);
    }

    @Override
    public User findByUsername(String username) throws Exception {
        UserEntity entity = userRepository.findByUsername(username);
        return UserMapper.toDomain(entity);
    }

    @Override
    public boolean existsByUsername(String username) throws Exception {
        return userRepository.existsByUsername(username);
    }
    
    @Override
    public void deleteByDocumentNumber(String documentNumber) throws Exception {
        UserEntity entity = userRepository.findByDocumentNumber(documentNumber);
        if (entity != null) {
            userRepository.delete(entity);
        } else {
            throw new Exception("No se puede eliminar un usuario que no existe.");
        }
    }
}
