package com.cars.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(RecordNotFound.class)
        public ResponseEntity<ErrorDetails> recordNotFoundException(RecordNotFound ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }

        /*@ExceptionHandler(SeatNotAvailable.class)
        public ResponseEntity<ErrorDetails> seatNotAvailableException(SeatNotAvailable ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }*/

        @ExceptionHandler(InvalidDateTime.class)
        public ResponseEntity<ErrorDetails> invalidDateTimeException(InvalidDateTime ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(InvalidEmail.class)
        public ResponseEntity<ErrorDetails> invalidEmail(InvalidEmail ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(InvalidPhoneNumber.class)
        public ResponseEntity<ErrorDetails> invalidPhoneNumber(InvalidPhoneNumber ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(RecordAlreadyExists.class)
        public ResponseEntity<ErrorDetails> recordAlreadyExists(RecordAlreadyExists ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(NullPointerException.class)
        public ResponseEntity<ErrorDetails> nullPointerException(NullPointerException ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler(AuthenticationException.class)
        public ResponseEntity<ErrorDetails> authenticationException(AuthenticationException ex, WebRequest request) {
            ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
    @ExceptionHandler(CarsNotAvailable.class)
    public ResponseEntity<ErrorDetails> carsNotAvailable(CarsNotAvailable ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    }


