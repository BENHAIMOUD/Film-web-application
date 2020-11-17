package me.ruiz.thierry.film.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

    /**
     * this method handles all exception
     * @param ex
     * @param request
     * @return
     */
    //@ExceptionHandler allows us to handle specified types of exceptions through one single method.
    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorsDetails> handleApiExceptions(ApiBaseException ex, WebRequest request){
        ErrorsDetails details = new ErrorsDetails(ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(details, ex.getStatusCode());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ValidationError validationError = new ValidationError();
        validationError.setUri(request.getDescription(false));

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
         for(FieldError f: fieldErrors) {
             validationError.addError(f.getDefaultMessage());
         }
        return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
    }
}