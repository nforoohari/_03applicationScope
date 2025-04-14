package ir.digixo.app1config;


import ir.digixo.ApplicationScopeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class Controller1 {

    @Autowired
    private ApplicationScopeClass applicationScopeClass;

    @GetMapping("/**")
    public String appHandler(Model model, HttpServletRequest req) {
        System.out.println("in app handler");
        System.out.println(applicationScopeClass.getName());
        model.addAttribute("pref", applicationScopeClass);
        model.addAttribute("uri", req.getRequestURI());
        return "mypage";
    }
}
