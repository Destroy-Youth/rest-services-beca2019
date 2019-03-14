package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.ILoginFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("login")
@Api(value = "login", description = "Operaciones con login")
public class LoginController {
    static final Logger LOG = LogManager.getLogger(LoginController.class);

    @Autowired
    private ILoginFacade loginFacade;

    @RequestMapping(
            value = "log",
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity<UserTO> login(@RequestBody LoginTO login) {
        UserTO user = loginFacade.login(login.getUsername(), login.getPassword());
        return new ResponseEntity<UserTO>(user, HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = "application/json")
    public ResponseEntity save(@RequestBody LoginTO loginTO){
        loginFacade.saveLogin(loginTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<Optional<LoginTO>> findOne(@RequestParam Long id){
        Optional<LoginTO> login = loginFacade.getLogin(id);
        return new ResponseEntity(login,HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            produces = "application/json")
    public ResponseEntity updateLogin(@RequestBody LoginTO loginTO){
        loginFacade.updateLogin(loginTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = "application/json")
    public ResponseEntity deleteLogin(@RequestParam Long id){
        loginFacade.deleteLogin(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
