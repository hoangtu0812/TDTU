package controller.admin;

import dao.AccountDAO;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@Controller
public class AdminAccountController {
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/admin/create-account", method = RequestMethod.GET)
    public String adminCreateAccountForm() {
        return "admin/AdminAccountCreate";
    }

    @RequestMapping(value = "/admin/create-account", method = RequestMethod.POST)
    public String adminCreateAccount(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String userMail = request.getParameter("userMail");
        String userPassword = request.getParameter("userPassword");
        String userGetBirthday = request.getParameter("userBirthday");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String userRole = request.getParameter("userRole");
        String userGetStatus = request.getParameter("userStatus");
        System.out.println(userMail + "/n" + userPassword
                                    + "/n" + userGetBirthday
                                    + "/n" + userName
                                    + "/n" + userPhone
                                    + "/n" + userGetStatus
                                    + "/n" + userRole
                                    );
        int userStatus = 0;
//        String userBirthday = null;
        java.sql.Date userBirthday = null;
        try {
            userStatus = Integer.parseInt(userGetStatus);
            userBirthday = Date.valueOf(userGetBirthday);


        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Account account = new Account(userMail, userPassword, userName, userBirthday, userPhone, userRole, userStatus);
        if (!account.validate()) {
            model.addAttribute("account", account);
            model.addAttribute("message", account.getMessage());
            return "admin/AdminAccountCreate";
        }
        if (!accountDAO.checkExist(account)) {
            model.addAttribute("message", accountDAO.getMessage());
            model.addAttribute("account", account);
            return "admin/AdminAccountCreate";
        } else {
            try {
                System.out.println(account.toString());
                accountDAO.create(account);
            } catch (Exception exception) {
                model.addAttribute("message", "Error!");
                return "admin/AdminAccountCreate";
            }
        }
        model.addAttribute("message","Success!");
        return "admin/AdminAccountCreate";
    }
}
