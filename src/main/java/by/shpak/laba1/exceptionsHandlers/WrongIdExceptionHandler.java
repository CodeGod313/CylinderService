package by.shpak.laba1.exceptionsHandlers;

import by.shpak.laba1.exceptions.WrongIdException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WrongIdExceptionHandler {
    private static Logger logger = Logger.getLogger(WrongIdExceptionHandler.class);

    @ExceptionHandler(WrongIdException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Answer with this ID not found")
    public void handleWrongIdException(){
        logger.error("Wrong id entered");
    }
}
