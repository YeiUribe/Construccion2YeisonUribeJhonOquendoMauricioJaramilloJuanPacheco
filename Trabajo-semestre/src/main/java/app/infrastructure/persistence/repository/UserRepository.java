package app.infrastructure.persistence.repository;

import app.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByDocumentNumber(String documentNumber) throws Exception;
    UserEntity findByUsername(String username) throws Exception;
    boolean existsByUsername(String username);
}
