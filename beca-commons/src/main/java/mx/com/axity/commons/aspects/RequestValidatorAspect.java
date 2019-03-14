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
import org.springframework.http.converter.HttpMessageNotReadableException;

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

            ErrorTO error = new ErrorTO();

            //TODO Cambiar todos estos ifs por cadena de responsabilidad
            if (e instanceof NoSuchElementException){
                error.setCode(ErrorCodes.NO_SUCH_ELEMENT);
                error.setMessage(e.getMessage());
                result = new ResponseEntity(error,HttpStatus.NOT_FOUND);
            }else if (e instanceof IllegalArgumentException) {
                error.setCode(13L);
                error.setMessage("Uno de los argumentos no es del tipo requerido.");
                result = new ResponseEntity(error, HttpStatus.BAD_REQUEST);

            }else if(e instanceof HttpMessageNotReadableException){
                error.setCode(ErrorCodes.NO_SUCH_ELEMENT);
                error.setMessage(e.getMessage());
                result = new ResponseEntity(error,HttpStatus.BAD_REQUEST);
            }else {
                error.setCode(666L);
                error.setMessage("YA VALIÓ MADRE");
                result = new ResponseEntity(error,HttpStatus.GONE);
            }

            LOG.error("Error: " + e.getMessage());
        }
        return result;
    }
}
