package ir.behi.phonebook.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * create User: behrooz.mh
 * Date: 12/19/2022
 * TIME: 10:21 AM
 **/
@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    private ResourceBundle resourceBundle;

    @org.springframework.web.bind.annotation.ExceptionHandler({ServiceException.class})
    public ResponseEntity<Object> exception(ServiceException exception) {
        if (exception.getKey() != null && !exception.getKey().isEmpty()) {
            return ResponseEntity.badRequest().body(resolveMessage(exception.getKey()));
        } else
            return ResponseEntity.badRequest().body(resolveMessage("entity.not.found"));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = resolveMessage(error.getDefaultMessage());
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    private String resolveMessage(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (Exception ex) {
            ex.printStackTrace();
            return key;
        }
    }

    private String resolveMessage(String key, String... values) {
        try {
            String msg = resourceBundle.getString(key);
            msg = MessageFormat.format(msg, values);
            return msg;
        } catch (Exception ex) {
            ex.printStackTrace();
            return key;
        }
    }
}
