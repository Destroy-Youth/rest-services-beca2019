package mx.com.axity.services.service;

import mx.com.axity.commons.aspects.ChainOfResponsability.ErrorCodes;
import mx.com.axity.commons.to.ErrorTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class becaServiceTest extends BaseTest {

    @Autowired
    IUserService service;

    private final static Long USER_ID = 5L;
    private final static String USER_NAME = "Ese";


    @Test
    public void updateOnlyIfRegisterExists() {

        UserDO newUser = new UserDO("Estela","Mar",22);
        newUser.setId(USER_ID);

        Optional<UserDO> user = service.findUser(USER_ID);
        Assert.assertTrue(user.isPresent());
        Assert.assertEquals(newUser.getId(), user.get().getId());
        Assert.assertNotEquals(newUser.getName(),user.get().getName());

        user = service.findUser(USER_ID);
        service.updateUser(newUser);

        Assert.assertEquals(newUser.getId(), user.get().getId());
        Assert.assertEquals(newUser.getName(),user.get().getName());
    }

    @Test
    public void getErrorTOIfUserRegisterDoesNotExists(){
        UserDO newUser = new UserDO("Estela","Mar",22);
        newUser.setId(123L);

        NoSuchElementException noSuchElementException = new NoSuchElementException();

        try {
            //TODO cambiar service a facade
            service.updateUser(newUser);
//            Assert.assertTrue(false);
        } catch (Throwable e) {
            System.out.println("yastoy aki////////////////////////////////////////////////////////////////////////////////");
            Assert.assertEquals("No value present", e.getMessage());
        }

    }

    @Test
    public void checkDaoResult(){
        List<UserDO> userDOList = service.getAllUsers();
        String i = userDOList.get(1).getLoginDO().getPassword();
        System.out.println(i);
        Assert.assertTrue(true);
    }
}
