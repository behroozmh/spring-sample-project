package ir.behi.library.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * create User: sys270
 * Date: 12/21/2022
 * TIME: 8:45 AM
 **/
@Component
public class Tools {

    private ResourceBundle resourceBundle;

    public Tools(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public String resolveMessage(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (Exception ex) {
            ex.printStackTrace();
            return key;
        }
    }

    public String resolveMessage(String key, String... values) {
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
