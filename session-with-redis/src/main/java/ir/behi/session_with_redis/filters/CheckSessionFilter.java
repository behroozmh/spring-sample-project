package ir.behi.session_with_redis.filters;

import ir.behi.session_with_redis.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Configuration
public class CheckSessionFilter implements Filter {
    @Autowired
    private HttpSession session;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object po = session.getAttribute("person");
        if (po != null) {
            PersonDTO dto = (PersonDTO) po;
            System.out.println("Person dto in Session= " + dto.getFirstName()
                    + " "
                    + dto.getLastName());
        }
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
