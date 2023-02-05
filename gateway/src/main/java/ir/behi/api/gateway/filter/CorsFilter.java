package ir.behi.api.gateway.filter;

import ir.behi.api.gateway.config.Dashboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration("myCorsFilter")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    private Dashboard dashboard;

    public CorsFilter(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        //
        String origins = dashboard.getCORS_ALLOW_ORIGINS();
        String hosts = dashboard.getALLOW_HOST();
        String methods = dashboard.getCORS_ALLOW_METHODS();
        //
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,x-www-form-urlencoded,access-control-allow-origin, authorization, content-type, x-requested-with");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", methods);

        String reqOrigin = request.getHeader("origin");
        String defaultOrigin = origins.split(",")[0];

        if (reqOrigin == null || reqOrigin.isEmpty())
            reqOrigin = defaultOrigin;

        if (matchOriginWhiteList(reqOrigin, origins))
            response.setHeader("Access-Control-Allow-Origin", reqOrigin);
        else {
            response.setHeader("Access-Control-Allow-Origin", defaultOrigin);
        }

        ///TODO://BEHI007 remove to other Filter for check referer
        String host = request.getHeader("host");
        String reqReferer = request.getHeader("Referer");
        String reqUrl = request.getRequestURI();
        log.info("######## host= " + host + " ## Referer= " + reqReferer
                + " ## getRequestURI=" + reqUrl + " ########");
        if (!matchHostsWhiteList(host, hosts)) {
            throw new ServletException("Host failed: Host is not valid");
        }

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(request, response);
        }

    }

    private boolean matchOriginWhiteList(String reqOrigin, String origins) {
        if (reqOrigin == null || reqOrigin.isEmpty() || reqOrigin.equalsIgnoreCase("")
                || origins.equalsIgnoreCase("*"))
            return true;
        //
        origins = StringUtils.trimAllWhitespace(origins);
        Set<String> whiteListOrigin = StringUtils.commaDelimitedListToSet(origins);
        if (whiteListOrigin != null && whiteListOrigin.size() > 0) {
            return whiteListOrigin.stream().anyMatch(f -> f.equalsIgnoreCase(reqOrigin));
        }
        return false;
    }

    private boolean matchHostsWhiteList(String reqValue, String whiteList) {
        if (reqValue == null || reqValue.isEmpty() || "".equalsIgnoreCase(reqValue)
                || whiteList.equalsIgnoreCase("*"))
            return true;
        whiteList = StringUtils.trimAllWhitespace(whiteList);
        Set<String> whiteListOrigin = StringUtils.commaDelimitedListToSet(whiteList);
        if (whiteListOrigin != null && whiteListOrigin.size() > 0) {
            return whiteListOrigin.stream().anyMatch(f -> f.equalsIgnoreCase(reqValue));
        }
        return false;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {
    }

}
