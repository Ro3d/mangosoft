package tech.mangosoft.ro3d.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class Bootstrapper {

    public static void main(String[] args) {
        SpringApplication.run(Bootstrapper.class, args);
    }
}