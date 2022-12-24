package ir.behi.library.exception;

import ir.behi.library.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:22 AM
 **/
@RestControllerAdvice
public class ErrorHandler {
    @Autowired
    private Tools tools;

    @org.springframework.web.bind.annotation.ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> exception(ServiceException exception) {
        if (exception.getKey() != null && !exception.getKey().isEmpty()) {
            return ResponseEntity.badRequest().body(tools.resolveMessage(exception.getKey()));
        } else
            return ResponseEntity.badRequest().body(tools.resolveMessage("internal.server.error",
                    exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = tools.resolveMessage(error.getDefaultMessage());
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
    public ResponseEntity<Object> exception(Exception exception) {
        return ResponseEntity.internalServerError().body(tools.resolveMessage("internal.server.error",
                exception.getMessage()));
    }


}
