package by.shpak.laba1.exceptionsHandlers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class MissingParameterExceptionHandler {
    public static final Logger logger = Logger.getLogger(MissingParameterExceptionHandler.class);
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Missing parameters")
    public void handleMissingParams(MissingServletRequestParameterException ex){
        String name = ex.getParameterName();
        logger.error(name + "is missing");
    }
}