package mx.com.axity.services.facade;

import mx.com.axity.commons.to.UserTO;

import java.util.List;
import java.util.Optional;

public interface IUserFacade {

    Integer operation(Integer a, Integer b);

    List<UserTO> getAllUsers();
    Optional<UserTO> getUser(Long id);
    void saveUser(UserTO userTO);
    void updateUser(UserTO userTO);
    void deleteUser(Long id);
}
