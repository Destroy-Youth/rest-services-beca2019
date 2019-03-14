package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.ILoginFacade;
import mx.com.axity.services.service.ILoginService;
import mx.com.axity.services.service.IbecaService;
import mx.com.axity.services.service.impl.LoginServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Optional;

@Component
public class LoginFacadeImpl implements ILoginFacade {

    @Autowired
    private ILoginService loginService;
    @Autowired
    private IbecaService userService;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public Optional<LoginTO> getLogin(Long id) {
        Optional<LoginDO> loginDO = loginService.getLogin(id);

        Type type = new TypeToken<Optional<LoginTO>>() {}.getType();
        Optional<LoginTO> loginTO = modelMapper.map(loginDO,type);
        return loginTO;
    }

    @Override
    public void saveLogin(LoginTO loginTO) {
        Type type = new TypeToken<LoginDO>() {}.getType();
        LoginDO loginDO = modelMapper.map(loginTO,type);
        loginService.saveLogin(loginDO);
    }

    @Override
    public void updateLogin(LoginTO loginTO) {
        Type type = new TypeToken<LoginDO>() {}.getType();
        LoginDO loginDO = modelMapper.map(loginTO,type);
        loginService.updateLogin(loginDO);
    }

    @Override
    public void deleteLogin(Long id) {
        loginService.deleteLogin(id);
    }

    @Override
    public UserTO login(String username, String password) {
        UserDO userDO = loginService.login(username,password);
        UserTO userTO;

        Type userTOType = new TypeToken<UserTO>() {}.getType();
        userTO = modelMapper.map(userDO,userTOType);
        return userTO;
    }
}
