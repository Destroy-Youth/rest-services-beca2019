package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.services.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public List<LoginDO> getAllLogins() {
        return (List<LoginDO>) loginDAO.findAll();
    }

    @Override
    public Optional<LoginDO> getLogin(Long id) {
        return loginDAO.findById(id);
    }

    @Override
    public void saveLogin(LoginDO loginDO) {
        loginDAO.save(loginDO);
    }

    @Override
    public void updateLogin(LoginDO loginDO) {
        loginDAO.save(loginDO);
    }

    @Override
    public void deleteLogin(Long id) {
        loginDAO.deleteById(id);
    }

    @Override
    public Optional<LoginDO> getLog(LoginDO loginDO) {
        return loginDAO.findByUsernameAndPassword(loginDO.getUsername(),loginDO.getPassword());
    }
}
