package ir.behi.api.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@PropertySource(value = "classpath:application.yml")
public class Dashboard {
    @Value("${auth.logout.url}")
    private String LOGOUT_URL;
    //    @Value("${spring.cloud.gateway.routes.authorize.url}")
    private String AUTHORIZATION_URL;
    @Value("${my.white-list.methods}")
    private String CORS_ALLOW_METHODS;
    @Value("${my.white-list.origin}")
    private String CORS_ALLOW_ORIGINS;
    @Value("${my.white-list.host}")
    private String ALLOW_HOST;

    public String getLOGOUT_URL() {
        return LOGOUT_URL;
    }

    public void setLOGOUT_URL(String LOGOUT_URL) {
        this.LOGOUT_URL = LOGOUT_URL;
    }

    public String getAUTHORIZATION_URL() {
        return AUTHORIZATION_URL;
    }

    public void setAUTHORIZATION_URL(String AUTHORIZATION_URL) {
        this.AUTHORIZATION_URL = AUTHORIZATION_URL;
    }

    public String getCORS_ALLOW_METHODS() {
        return CORS_ALLOW_METHODS;
    }

    public void setCORS_ALLOW_METHODS(String CORS_ALLOW_METHODS) {
        this.CORS_ALLOW_METHODS = CORS_ALLOW_METHODS;
    }

    public String getCORS_ALLOW_ORIGINS() {
        return CORS_ALLOW_ORIGINS;
    }

    public void setCORS_ALLOW_ORIGINS(String CORS_ALLOW_ORIGINS) {
        this.CORS_ALLOW_ORIGINS = CORS_ALLOW_ORIGINS;
    }

    public String getALLOW_HOST() {
        return ALLOW_HOST;
    }

    public void setALLOW_HOST(String ALLOW_HOST) {
        this.ALLOW_HOST = ALLOW_HOST;
    }
}
