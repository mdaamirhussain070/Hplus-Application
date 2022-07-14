package springmvc.hplusapp.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler({ApplicationException.class, AsyncRequestTimeoutException.class})
    public String exceptionHandler(){
        System.out.println("We are in ExceptionHandler of Login Controller");
        return "error";
    }
}
