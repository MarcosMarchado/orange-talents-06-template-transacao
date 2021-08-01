package br.com.zupacademy.transacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ErroPadrao> objectNotFoundException(ObjectNotFoundException exception){
        ErroPadrao erroPadrao = new ErroPadrao(Arrays.asList(exception.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroPadrao);
    }

}
