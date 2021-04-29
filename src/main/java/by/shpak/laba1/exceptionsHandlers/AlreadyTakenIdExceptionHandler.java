package by.shpak.laba1.exceptionsHandlers;

import by.shpak.laba1.exceptions.AlreadyTakenIdException;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AlreadyTakenIdExceptionHandler {

    private static Logger logger = Logger.getLogger(AlreadyTakenIdExceptionHandler.class);

    @ExceptionHandler(AlreadyTakenIdException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This id is already taken")
    public void handleAlreadyTakenIdException(){
        logger.error("This id is already taken");
    }
}
