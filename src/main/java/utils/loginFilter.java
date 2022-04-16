package utils;

import javax.servlet.*;
import java.io.IOException;

public class loginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LogFilter init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }


}
