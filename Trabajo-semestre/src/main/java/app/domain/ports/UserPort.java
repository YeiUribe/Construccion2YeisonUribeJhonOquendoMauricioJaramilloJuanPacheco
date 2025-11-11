package app.domain.ports;

import app.domain.model.User;

public interface UserPort {

    void save(User user)throws Exception;;

    User findByDocumentNumber(String documentNumber) throws Exception;

    User findByUsername(String username) throws Exception;

    boolean existsByUsername(String username) throws Exception;
    
    void deleteByDocumentNumber(String documentNumber) throws Exception;
}
