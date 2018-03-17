package br.com.cinq.exception;

import org.springframework.stereotype.Component;

/**
 * @author William
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }

}
