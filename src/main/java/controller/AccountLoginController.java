package controller;

import dao.AccountDAO;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class AccountLoginController {
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response, Model model) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        //check if login
        if (session.getAttribute("sessionAccount") != null) {
            return "redirect:/index";
        }
        Cookie[] cookies = request.getCookies();
        String email = "";
        String password = "";
        int co = 0;
        if (cookies != null) {
            while (co < cookies.length) {
                if(cookies[co].getName().equals("cookieEmail")) {
                    email = cookies[co].getValue();
                }
                if (cookies[co].getName().equals("cookiePassword")) {
                    password = cookies[co].getValue();
                }
                co++;
            }
            model.addAttribute("cookieEmail", email);
            model.addAttribute("cookiePassword", password);

        }
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String userMail = request.getParameter("userMail");
        String userPassword = request.getParameter("userPassword");
        Account account = new Account();
        try {
            //Huỷ tất cả các session nếu có
            request.getSession(true).invalidate();
            HttpSession session = request.getSession(true);
            account.setUserMail(userMail);
            account.setPassword(userPassword);
            //validate usermail and password
            if (!account.validateLogin()) {
                model.addAttribute("message", account.getMessage());
                model.addAttribute("account", account);
                return "login";
            } else {
                //check account on database
                if (!accountDAO.login(account)) {
                    model.addAttribute("account", account);
                    model.addAttribute("message", account.getMessage());
                    return "login";
                } else {
                    account = accountDAO.getAccount(account.getUserMail());
                    session.setAttribute("sessionAccount", account);
                    Cookie cookieEmail = new Cookie("cookieEmail", account.getUserMail());
                    Cookie cookiePassword = new Cookie("cookiePassword", account.getPassword());
                    if(request.getParameter("checkRemember") != null) {
                        cookieEmail.setMaxAge(60*60*24);
                        cookiePassword.setMaxAge(60*60*24);
                    } else {
                        cookieEmail.setMaxAge(0);
                        cookiePassword.setMaxAge(0);
                    }
                    response.addCookie(cookieEmail);
                    response.addCookie(cookiePassword);
                    //check account role
                    if (account.checkAdminRole()) {
                        return "redirect:/admin";
                    } else {
                        return "redirect:/index";
                    }
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
            return "404";
        }
    }
}
