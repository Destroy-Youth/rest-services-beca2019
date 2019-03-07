package mx.com.axity.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IUserFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value = "beca", description = "Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IUserFacade facade;


    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.facade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity saveUser(@RequestBody String json) throws IOException {
        LOG.info("Se invoca /user");

        ObjectMapper mapper=new ObjectMapper();
        UserTO userTO = mapper.readValue(json, UserTO.class);

        facade.saveUser(userTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Optional<UserTO>> getUser(@RequestParam Long id) {
        LOG.info("Se invoca /users");
        Optional<UserTO> userTO = facade.getUser(id);
        return new ResponseEntity<>(userTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO json) throws IOException {
        LOG.info("Se invoca /user");

        facade.updateUser(json);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@RequestParam Long id) {
        LOG.info("Se invoca /users");

        facade.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity operation() {
        LOG.info("Se invoca /operation");
        Integer result = facade.operation(4, 10);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
