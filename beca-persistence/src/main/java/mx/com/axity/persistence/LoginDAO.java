package mx.com.axity.persistence;

import mx.com.axity.model.LoginDO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginDAO extends CrudRepository<LoginDO,Long> {


    Optional<LoginDO> findByUsernameAndPassword(String username, String password);
}
