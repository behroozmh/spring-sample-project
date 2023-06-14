package ir.behi.session_with_redis.filters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

@Configuration
@PropertySource(value = "classpath:config.yml")
public class CheckSessionFilter implements Filter {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Value("${ratelimiter.period}")
    private Integer rateLimiterPeriod;
    @Value("${ratelimiter.time}")
    private Integer rateLimiterTime;

    public CheckSessionFilter(HttpSession session) {
        this.session = session;
    }

    private HttpSession session;
    private ResourceBundle bundle = ResourceBundle.getBundle("fa_IR");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (rateCheck()) {
            logger.warning("Rate exceed Limitaion for cal Service");
            response.sendError(HttpStatus.TOO_MANY_REQUESTS.value(), bundle.getString("rate.limiter.exception"));
        }
        filterChain.doFilter(request, response);
    }

    private boolean rateCheck() {
        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
