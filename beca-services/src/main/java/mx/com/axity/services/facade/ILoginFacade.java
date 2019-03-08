package mx.com.axity.services.facade;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;

import java.util.List;
import java.util.Optional;

public interface ILoginFacade {
    List<LoginTO> getAllLogins();
    Optional<LoginTO> getLogin(Long id);
    void updateLogin(LoginTO LoginTO);
    void saveLogin(LoginTO loginTO);
    void deleteLogin(Long id);

    Optional<UserTO> log(LoginTO loginTO);
}
