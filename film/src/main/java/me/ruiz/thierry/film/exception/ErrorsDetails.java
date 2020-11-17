package me.ruiz.thierry.film.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author Ayoub BENHAIMOUD.<ayoubbenhaimoud@gmail.com>
 * @created on 18/11/2020.
 */
public class ErrorsDetails {

    private String message;
    private String uri;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    //constructor

    public ErrorsDetails() {
        this.timestamp = new Date();
    }

    public ErrorsDetails(String message, String uri) {
        this();
        this.message = message;
        this.uri = uri;
    }
    // getters & setters

    public String getMessage() {
        return message;
    }

    public String getUri() {
        return uri;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUrl(String uri) {
        this.uri = uri;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
