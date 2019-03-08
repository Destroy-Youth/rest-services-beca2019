package mx.com.axity.services.service;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.model.LoginDO;

import java.util.List;
import java.util.Optional;

public interface ILoginService {
    List<LoginDO> getAllLogins();
    Optional<LoginDO> getLogin(Long id);
    void saveLogin(LoginDO loginDO);
    void updateLogin(LoginDO loginDO);
    void deleteLogin(Long id);

    Optional<LoginDO> getLog(LoginDO loginDO);
}
