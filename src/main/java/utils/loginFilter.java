package utils;

import model.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
/**
 * Check role to go to admin page
 * */
public class loginFilter implements Filter {
    public void init(FilterConfig config) {
        System.out.println("LogFilter init!");
    }
    /**
     * Role filter
     * */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException {
        servletRequest.setCharacterEncoding("UTF-8");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        try {
            //Get request path
            String servletPath = req.getServletPath();
            System.out.println("#INFO" + new Date() + " -ServletPath: " + servletPath + ", URL= " + req.getRequestURL());
            HttpSession session = req.getSession();
            Account account = (Account) session.getAttribute("sessionAccount");
            if (account != null) {
                String role =  account.getRole();
                if (role.trim().equalsIgnoreCase("superadmin") || role.trim().equalsIgnoreCase("admin")) {
                    servletRequest.setCharacterEncoding("UTF-8");
                    filterChain.doFilter(servletRequest, servletResponse);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/login");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath());
        }
    }

    public void destroy() {

    }


}
