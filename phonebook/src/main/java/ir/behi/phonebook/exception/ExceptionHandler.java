package ir.behi.phonebook.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.text.MessageFormat;
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
        }
        else
            return ResponseEntity.badRequest().body(resolveMessage("entity.not.found"));
    }

    private String resolveMessage(String key) {
        return resourceBundle.getString(key);
    }

    private String resolveMessage(String key, String... values) {
        String msg = resourceBundle.getString(key);
        msg = MessageFormat.format(msg, values);
        return msg;
    }
}
