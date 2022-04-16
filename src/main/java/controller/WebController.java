package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String home(){
        return "index";
    }
    @RequestMapping(value = "/page-not-found")
    public String pageNotFound() {
        return "404";
    }
}
