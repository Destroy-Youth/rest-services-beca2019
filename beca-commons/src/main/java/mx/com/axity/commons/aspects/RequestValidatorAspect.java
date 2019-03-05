package mx.com.axity.commons.aspects;

import mx.com.axity.commons.aspects.ChainOfResponsability.ErrorCodes;
import mx.com.axity.commons.exceptions.BusinessException;
import mx.com.axity.commons.to.ErrorTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

@Aspect
@Configuration
public class RequestValidatorAspect {

    static final Logger LOG = LogManager.getLogger(RequestValidatorAspect.class);

    @Around(value = "execution(* mx.com.axity.web.rest.*.*(..))  && args(..)")
    public ResponseEntity execute(ProceedingJoinPoint joinPoint) {
        ResponseEntity result;
        try {
            LOG.info("Access");
            LOG.info(String.format("Execution: %s", joinPoint.getSignature()));
            result = (ResponseEntity) joinPoint.proceed();
            return result;
        }catch (Throwable e) {
            LOG.info("Exception Ocurred");
            LOG.info("Execution: {}", joinPoint.getSignature());
            LOG.info("Exception: {}", e.getMessage());
            LOG.info("Exception: {}", e);
            //throw new BusinessException("Error", e);

            //TODO Cambiar todos estos ifs por cadena de responsabilidad
            if (e instanceof NoSuchElementException){

                ErrorTO error = new ErrorTO();
                error.setCode(ErrorCodes.NO_SUCH_ELEMENT);
                error.setMessage(e.getMessage());

                result = new ResponseEntity(error,HttpStatus.NOT_FOUND);
            }else {

                result = new ResponseEntity(HttpStatus.OK);
            }

            LOG.error("Error: " + e.getMessage());
        }
        return result;
    }
}
