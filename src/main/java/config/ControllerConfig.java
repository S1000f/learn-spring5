package config;

import ch11.MemberRegisterService;
import ch11.controller.RegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegisterService);

        return controller;
    }
}
