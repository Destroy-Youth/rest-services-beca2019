package mx.com.axity.services.facade;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;

import java.util.Optional;

public interface ILoginFacade {
    Optional<LoginTO> getLogin(Long id);
    void saveLogin(LoginTO loginTO);
    void updateLogin(LoginTO loginTO);
    void deleteLogin(Long id);

    UserTO login (String username, String password);
}
