package com.AccentureCrud.exception.globalException;

import com.AccentureCrud.exception.BusinessServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(BusinessServiceException.class)
    public ResponseEntity<String> handleBusinessServiceException(BusinessServiceException ex) {
        return new ResponseEntity<> (ex.getErrorMessage()+ex.getErrorCode(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleIllegalArgumentException(NoSuchElementException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleIllegalArgumentException(Exception ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}