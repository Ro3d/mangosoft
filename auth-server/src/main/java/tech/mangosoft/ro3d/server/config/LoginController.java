package tech.mangosoft.ro3d.server.config;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @RequestMapping(value = "/user/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        String cpw = RandomStringUtils.random(6, "abcdefhijkprstuvwx");
        request.getSession().setAttribute("current_password", cpw);
        modelAndView.addObject("current_password", cpw);
        return modelAndView;
    }
}
