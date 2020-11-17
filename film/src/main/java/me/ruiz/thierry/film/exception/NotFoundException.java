package me.ruiz.thierry.film.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
public class NotFoundException extends  ApiBaseException {

    public NotFoundException(String message) {
        super(message);
    }
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
