package controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminDashboardController {
    @RequestMapping(value = "/admin/dashboard", method = RequestMethod.GET)
    public String adminDashboard() {
        return "admin/dashboard";
    }
    @RequestMapping(value = "/admin/account-manager", method = RequestMethod.GET)
    public String adminAccountManager() {
        return "admin/AdminAccountManager";
    }
}
