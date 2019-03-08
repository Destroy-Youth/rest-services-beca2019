package mx.com.axity.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import mx.com.axity.commons.to.LoginTO;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.ILoginFacade;
import mx.com.axity.services.facade.IUserFacade;
import org.apache.catalina.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("examen")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
public class LoginController {
    static final Logger LOG = LogManager.getLogger(HelloController.class);

    @Autowired
    ILoginFacade facade;

    @Autowired
    IUserFacade userFacade;


    @RequestMapping(value = "/logins", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<LoginTO>> getAllLogins() {
        LOG.info("Se invoca /Logins");
        List<LoginTO> logins = this.facade.getAllLogins();
        return new ResponseEntity<>(logins, HttpStatus.OK);
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Optional<LoginTO>> getLogin(@RequestParam Long id) {
        LOG.info("Se invoca /logins");
        Optional<LoginTO> LoginTO = facade.getLogin(id);
        return new ResponseEntity<>(LoginTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updateLogin(@RequestBody LoginTO json) throws IOException {
        LOG.info("Se invoca /Login");

        facade.updateLogin(json);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.userFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity saveUser(@RequestBody String json) throws IOException {
        LOG.info("Se invoca /user");

        ObjectMapper mapper=new ObjectMapper();
        UserTO userTO = mapper.readValue(json, UserTO.class);

        userFacade.saveUser(userTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Optional<UserTO>> getUser(@RequestParam Long id) {
        LOG.info("Se invoca /users");
        Optional<UserTO> userTO = userFacade.getUser(id);
        return new ResponseEntity<>(userTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO json) throws IOException {
        LOG.info("Se invoca /user");

        userFacade.updateUser(json);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@RequestParam Long id) {
        LOG.info("Se invoca /users");

        userFacade.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/login", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteLogin(@RequestParam Long id) {
        LOG.info("Se invoca /users");

        facade.deleteLogin(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveLogin(@RequestParam LoginTO loginTO) {
        LOG.info("Se invoca /users");

        facade.saveLogin(loginTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Optional<UserTO>> log(@RequestBody LoginTO loginTO) {
        LOG.info("Se invoca /users");

        Optional<UserTO> user = facade.log(loginTO);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
