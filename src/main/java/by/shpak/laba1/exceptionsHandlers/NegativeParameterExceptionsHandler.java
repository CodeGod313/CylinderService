package by.shpak.laba1.exceptionsHandlers;

import by.shpak.laba1.exceptions.NegativeParameterException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NegativeParameterExceptionsHandler {
    private static final Logger logger = Logger.getLogger(NegativeParameterExceptionsHandler.class);
    @ExceptionHandler(NegativeParameterException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Negative parameters are not allowed")
    public void handleNegativeParams(NegativeParameterException ex){
        logger.error("Found negative parameters");
    }
}
