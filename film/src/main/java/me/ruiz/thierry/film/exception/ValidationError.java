package me.ruiz.thierry.film.exception;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
public class ValidationError {

    private List<String> errors;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    //constructor

    public ValidationError() {
        this.timestamp = new Date() ;
    }
    //method
    public void addError(String error) {
        this.errors.add(error);
        this.errors = new ArrayList<>();
    }

    //Getters & Setters

    public List<String> getErrors() {
        return errors;
    }

    public String getUri() {
        return uri;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


}