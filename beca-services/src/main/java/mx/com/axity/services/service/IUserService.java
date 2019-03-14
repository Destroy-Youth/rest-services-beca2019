package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Integer sum(Integer sum1,Integer sum2);
    Integer subtraction(Integer sub1,Integer sub2);
    Integer multiplication(Integer mult1,Integer mult2);
    Integer division(Integer dividend, Integer divider);

    List<UserDO> getAllUsers();
    Optional<UserDO> getUser(Long id);
    void saveUser(UserDO userDO);
    void updateUser(UserDO userDO);
    void deleteUser(Long id);
    Optional<UserDO> findUser(Long id);

}
