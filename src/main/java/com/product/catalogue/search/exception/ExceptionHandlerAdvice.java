package com.product.catalogue.search.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.product.catalogue.search.model.ServiceError;

@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

   @Override
   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       String error = "Malformed JSON request";
       return buildResponseEntity(new ServiceError(HttpStatus.BAD_REQUEST, error, ex));
   }
   
   @ExceptionHandler(Exception.class)
   public ResponseEntity<Object> handleGenericException(Exception ex) {
       String error = "Unexpected error!";
       return buildResponseEntity(new ServiceError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex));
   }
   
   @ExceptionHandler(ProductNotFoundException.class)
   public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException ex) {
       String error = "Product not found!";
       return buildResponseEntity(new ServiceError(HttpStatus.NOT_FOUND, error, ex));
   }
   
   @ExceptionHandler(ProductAlreadyPresentException.class)
   public ResponseEntity<Object> handleProductAlreadyPresentException(ProductAlreadyPresentException ex) {
       String error = "Product already present!";
       return buildResponseEntity(new ServiceError(HttpStatus.FOUND, error, ex));
   }
   
   private ResponseEntity<Object> buildResponseEntity(ServiceError serviceError) {
       return new ResponseEntity<>(serviceError, serviceError.getStatus());
   }


}