package mx.com.axity.services.service.impl;

import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.LoginDAO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private UserDAO userDAO;

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
        loginDAO.save(loginDAO.findById(loginDO.getId()).get());
    }

    @Override
    public void deleteLogin(Long id) {
        loginDAO.deleteById(id);
    }

    @Override
    public UserDO login(String username, String password) {
        LoginDO login = loginDAO.findByUsernameAndPassword(username,password).get();
        return userDAO.findById(login.getUser()).get();
    }
}
