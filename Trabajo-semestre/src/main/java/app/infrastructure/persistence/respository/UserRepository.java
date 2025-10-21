package app.infrastructure.persistence.respository;

import app.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByDocumentNumber(String documentNumber);
    UserEntity findByUsername(String username);
    boolean existsByUsername(String username);
}
