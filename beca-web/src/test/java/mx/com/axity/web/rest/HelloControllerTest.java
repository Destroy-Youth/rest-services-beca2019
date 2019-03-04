package mx.com.axity.web.rest;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.web.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Optional;

public class HelloControllerTest extends BaseTest {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    @Test
    public void exampleTest() {

        //this.entityManager.persist(new UserDO("Javier", "Rodriguez", 1));

        List<UserTO> users = this.becaFacade.getAllUsers();

        Assert.assertEquals(1, users.size());
    }

    @Test
    public void shouldReturnOneOptionalUserTO(){
        Optional<UserTO> userTO = becaFacade.getUser(1L);

        Assert.assertTrue(userTO.isPresent());
    }
}
