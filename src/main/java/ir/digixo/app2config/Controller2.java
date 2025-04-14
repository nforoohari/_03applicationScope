package ir.digixo.app2config;

import ir.digixo.ApplicationScopeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class Controller2 {
    @Autowired
    private ApplicationScopeClass applicationScopeClass;

    @GetMapping("/**")
    public String appHandler(Model model, HttpServletRequest req) {

        System.out.println(applicationScopeClass.getName());
        model.addAttribute("pref", applicationScopeClass);
        model.addAttribute("uri", req.getRequestURI());
        return "mypage";
    }
}
