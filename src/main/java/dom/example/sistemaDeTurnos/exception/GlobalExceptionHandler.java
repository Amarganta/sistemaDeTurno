package dom.example.sistemaDeTurnos.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger();
    @ExceptionHandler
    public ResponseEntity<?> todosLosErrores(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity<>("Error " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> noEncontrado(EntityNotFoundException e, WebRequest webRequest){
        logger.error(e.getMessage());
        return new ResponseEntity<>("Error: " + e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> peticionMalFormada(BadRequestException e, WebRequest webRequest){
        logger.error(e.getMessage());
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
