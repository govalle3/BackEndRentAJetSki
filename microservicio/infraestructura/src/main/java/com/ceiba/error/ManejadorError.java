package com.ceiba.error;
import com.ceiba.usuario.excepcion.*;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;


public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final Logger LOG = (Logger) LoggerFactory.getLogger(ManejadorError.class);

    private static final String MESSAGE_ALL_ERROR = "Ha ocurrido un error";

    private static final ConcurrentHashMap<String, Integer> ERRORS = new ConcurrentHashMap<>();

    public ManejadorError() {
        ERRORS.put(ExcepcionMotoAlquilada.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        ERRORS.put(ExcepcionNoHayServicio.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        ERRORS.put(ExcepcionTiempoAlquilerMenosDiezMinutos.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        ERRORS.put(ExcepcionUsuarioMenorDeEdad.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        ERRORS.put(ExcepcionUsuarioMoroso.class.getSimpleName(), HttpStatus.NOT_ACCEPTABLE.value());
        ERRORS.put(ExcepcionUsuarioNoExistente.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> response;
        String exceptionName = exception.getClass().getSimpleName();
        String message = exception.getMessage();

        Integer code = ERRORS.get(exceptionName);

        if (code == null) {
            LOG.error(exceptionName, message);
            Error error = new Error(exceptionName, MESSAGE_ALL_ERROR);
            response = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            Error error = new Error(exceptionName, message);
            response = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        }

        return response;
    }
}

