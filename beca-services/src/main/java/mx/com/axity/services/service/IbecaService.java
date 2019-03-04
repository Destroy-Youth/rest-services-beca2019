package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import java.util.List;

public interface IbecaService {

    List<UserTO> getUsers();
    Integer sum(Integer sum1,Integer sum2);
    Integer subtraction(Integer sub1,Integer sub2);
    Integer multiplication(Integer mult1,Integer mult2);
    Integer division(Integer dividend, Integer divider);
}
