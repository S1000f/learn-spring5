package config;

import ch11.AuthService;
import ch11.MemberDao;
import ch11.MemberRegisterService;
import ch11.controller.*;
import ch11.survey.SurveyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class ControllerConfig {

    @Autowired
    private MemberRegisterService memberRegisterService;
    @Autowired
    private AuthService authService;
    @Autowired
    private MemberDao memberDao;

    @Bean
    public RegisterController registerController() {
        RegisterController controller = new RegisterController();
        controller.setMemberRegisterService(memberRegisterService);

        return controller;
    }

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

    @Bean
    public LoginController loginController() {
        LoginController loginController = new LoginController();
        loginController.setAuthService(authService);
        return loginController;
    }

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public ChangePwdController changePwdController() {
        return new ChangePwdController();
    }

    @Bean
    public ExampleController exampleController() {
        return new ExampleController();
    }

    @Bean
    public MemberDetailController memberDetailController() {
        MemberDetailController controller = new MemberDetailController();
        controller.setMemberDao(memberDao);

        return controller;
    }

    @Bean
    public RestMemberController restMemberController() {
        RestMemberController controller = new RestMemberController();
        controller.setMemberDao(memberDao);
        controller.setMemberRegisterService(memberRegisterService);

        return controller;
    }
}
