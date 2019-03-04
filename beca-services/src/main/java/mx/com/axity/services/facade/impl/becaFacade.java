package mx.com.axity.services.facade.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.facade.IbecaFacade;
import mx.com.axity.services.service.IbecaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class becaFacade implements IbecaFacade {

    @Autowired
    private IbecaService becaService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Integer operation(Integer a, Integer b) {

        Integer c = becaService.sum(a,b);
        b = becaService.subtraction(c, a);
        Integer d = becaService.multiplication(b,4);
        return becaService.division(d,4);
    }

    @Override
    public List<UserTO> getAllUsers() {

        List<UserDO> userDOList = becaService.getAllUsers();
        List<UserTO> userTOList =new ArrayList<>();

        Type userTOType = new TypeToken<List<UserTO>>() {}.getType();
        userTOList = modelMapper.map(userDOList,userTOType);

        return userTOList;
    }
}
