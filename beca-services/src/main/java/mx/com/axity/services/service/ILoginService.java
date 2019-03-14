package mx.com.axity.services.service;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;

import java.util.Optional;

public interface ILoginService {
    Optional<LoginDO> getLogin(Long id);
    void saveLogin(LoginDO loginDO);
    void updateLogin(LoginDO loginDO);
    void deleteLogin(Long id);

    UserDO login (String username,String password);

}
