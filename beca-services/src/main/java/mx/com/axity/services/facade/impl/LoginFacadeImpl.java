package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.LoginDO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.ILoginFacade;
import mx.com.axity.services.service.ILoginService;
import mx.com.axity.services.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Component
public class LoginFacadeImpl implements ILoginFacade {

    @Autowired
    private ILoginService becaService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IUserService userService;

    @Override
    public List<LoginTO> getAllLogins() {

        List<LoginDO> LoginDOList = becaService.getAllLogins();
        List<LoginTO> LoginTOList;

        Type LoginTOType = new TypeToken<List<LoginTO>>() {}.getType();
        LoginTOList = modelMapper.map(LoginDOList,LoginTOType);

        return LoginTOList;
    }

    @Override
    public Optional<LoginTO> getLogin(Long id) {

        Optional<LoginDO> LoginDO = becaService.getLogin(id);
        Optional<LoginTO> LoginTO;

        Type LoginTOType = new TypeToken<Optional<LoginTO>>() {}.getType();
        LoginTO = modelMapper.map(LoginDO,LoginTOType);

        return LoginTO;
    }

    @Override
    public void updateLogin(LoginTO LoginTO) {
        LoginDO LoginDO;
        Type LoginDOType = new TypeToken<LoginDO>() {}.getType();
        LoginDO = modelMapper.map(LoginTO,LoginDOType);
        becaService.saveLogin(becaService.getLogin(LoginTO.getId()).get());
    }

    @Override
    public void saveLogin(LoginTO LoginTO) {
        LoginDO LoginDO;
        Type LoginDOType = new TypeToken<LoginDO>() {}.getType();
        LoginDO = modelMapper.map(LoginTO,LoginDOType);
        becaService.saveLogin(LoginDO);
    }

    @Override
    public void deleteLogin(Long id) {
        becaService.deleteLogin(id);
    }

    @Override
    public Optional<UserTO> log(LoginTO loginTO) {

        LoginDO loginDO;
        Type LoginDOType = new TypeToken<LoginDO>() {}.getType();
        loginDO = modelMapper.map(loginTO,LoginDOType);

        LoginDO login = becaService.getLog(loginDO).get();
        UserDO user = userService.findUser(login.getId()).get();

        Optional<UserTO> userTO;

        Type userTOType = new TypeToken<Optional<UserTO>>() {}.getType();
        userTO = modelMapper.map(user,userTOType);

//        Optional<UserTO> userTooooo;
//        userTooooo = userTO.get();
//        return userTooooo;
        return userTO;
    }


}
