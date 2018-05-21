package tech.mangosoft.ro3d.server.config;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
}
