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


@RequestMapping("beca")@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@Api(value = "beca", description = "Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IUserFacade userFacade;



    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity operation() {
        LOG.info("Se invoca /operation");
        Integer result = userFacade.operation(4, 10);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
