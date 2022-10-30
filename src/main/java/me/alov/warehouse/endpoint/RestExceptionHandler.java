package me.alov.warehouse.endpoint;

import me.alov.warehouse.exception.InsufficientItemException;
import me.alov.warehouse.model.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InsufficientItemException.class})
    public ResponseEntity<ApiResponse> handleItemException(InsufficientItemException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ApiResponse> globalExeptionHandler(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponse.error(e.getMessage()));
    }
}
