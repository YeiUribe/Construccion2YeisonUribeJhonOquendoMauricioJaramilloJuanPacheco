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


    public User save(User user) throws Exception {
        UserEntity entity = UserMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(entity);
        return UserMapper.toDomain(savedEntity);
    }


    public User findByDocumentNumber(String documentNumber) throws Exception {
        UserEntity entity = userRepository.findByDocumentNumber(documentNumber);
        return UserMapper.toDomain(entity);
    }

  
    public User findByUsername(String username) throws Exception {
        UserEntity entity = userRepository.findByUsername(username);
        return UserMapper.toDomain(entity);
    }

  
    public boolean existsByUsername(String username) throws Exception {
        return userRepository.existsByUsername(username);
    }
}
