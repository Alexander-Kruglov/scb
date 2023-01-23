package scb.backend.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import scb.backend.exception.DeliveryNotFoundException;

@ControllerAdvice
public class DeliveryNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DeliveryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String employeeNotFoundHandler(DeliveryNotFoundException ex) {
        return ex.getMessage();
    }
}
