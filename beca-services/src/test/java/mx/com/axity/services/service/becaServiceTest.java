package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class becaServiceTest extends BaseTest {

    @Test
    public void exampleTest() {

        List<UserTO> users = this.becaService.getUsers();

        Assert.assertEquals(1, users.size());
    }

    @Test
    public void returnsTheSumOfTwoNumbers(){

        Integer num1 = 5;
        Integer num2 = 10;

        int result = becaService.sum(num1,num2);

        Assert.assertEquals(15,result);

    }

    @Test
    public void returnsTheSubtractionOfTwoNumbers(){

        Integer num1 = 5;
        Integer num2 = 10;

        int result = becaService.subtraction(num1,num2);

        Assert.assertEquals(-5,result);

    }

    @Test
    public void returnsTheDivisionOfTwoNumbers(){

        Integer num1 = 10;
        Integer num2 = 5;

        int result = becaService.division(num1,num2);

        Assert.assertEquals(2,result);

    }

    @Test
    public void returnsTheMultiplicationOfTwoNumbers(){

        Integer num1 = 10;
        Integer num2 = 5;

        int result = becaService.multiplication(num1,num2);

        Assert.assertEquals(50,result);

    }
}
