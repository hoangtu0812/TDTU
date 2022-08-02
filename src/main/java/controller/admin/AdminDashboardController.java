package controller.admin;

import dao.AccountDAO;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminDashboardController {
    @Autowired
    private AccountDAO accountDAO;
    @RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
    public String adminDashboard() {
        return "admin/dashboard";
    }
    @RequestMapping(value = "/admin/account-manager", method = RequestMethod.GET)
    public String adminAccountManager(Model model) {
        List<Account> accountList = new ArrayList<>();
        accountList = accountDAO.getAccountList();
        model.addAttribute("accountList", accountList);
        return "admin/AdminAccountManager";
    }
}
