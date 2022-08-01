package controller;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@Controller
public class AccountLoginController {
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String userMail = request.getParameter("userMail");
        String userPassword = request.getParameter("userPassword");
        System.out.println(userMail);
        System.out.println(userPassword);
//        accountDAO.create();
//        System.out.println(accountDAO.count());
        try {
            //Huỷ tất cả các session nếu có
            request.getSession(true).invalidate();
            HttpSession session = request.getSession(true);

        } catch (Exception exception) {

        }
        return "login";
    }
}
