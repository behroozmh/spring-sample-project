package ir.behi.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:22 AM
 **/
@Configuration
public class AppConfig {

    @Bean
    public ResourceBundle resourceBundle() {
        return ResourceBundle.getBundle("messages", new Locale("fa_IR"));
    }
}
