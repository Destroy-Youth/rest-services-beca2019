package mx.com.axity.services.service.impl;

import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    static final Logger LOG = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Integer sum(Integer sum1, Integer sum2) {
        return sum1 + sum2;
    }

    @Override
    public Integer subtraction(Integer sub1, Integer sub2) {
        return sub1 - sub2;
    }

    @Override
    public Integer multiplication(Integer mult1, Integer mult2) {
        return mult1*mult2;
    }

    @Override
    public Integer division(Integer dividend, Integer divider) {
        return dividend/divider;
    }

    @Override
    public List<UserDO> getAllUsers() {
        return (List<UserDO>) userDAO.findAll();
    }


    public Optional<UserDO> getUser(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public void saveUser(UserDO userDO) {
        userDAO.save(userDO);
    }

    @Override
    public void updateUser(UserDO userDO) {
        userDAO.save(userDO);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }

    @Override
    public Optional<UserDO> findUser(Long id) {
        return userDAO.findById(id);
    }


}
