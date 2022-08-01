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
import java.util.Date;

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

        int userStatus = 0;
        Date processDate;
        java.sql.Date userBirthday = null;
        try {
            userStatus = Integer.parseInt(userGetStatus);
//            userBirthday = new SimpleDateFormat("dd/mm/yyyy").parse(userGetBirthday);
            processDate = new SimpleDateFormat("yyyy/MM/dd").parse(userGetBirthday);
            userBirthday = new java.sql.Date(processDate.getDate());


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
                accountDAO.create(account);
            } catch (Exception exception) {
                model.addAttribute("message", "Error!");
                return "admin/AdminAccountCreate";
            }
        }
        return "";
    }
}
