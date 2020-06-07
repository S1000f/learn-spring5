package config;

import ch11.MemberRegisterService;
import ch11.controller.ExampleController;
import ch11.controller.RegisterController;
import ch11.survey.SurveyController;
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

    @Bean
    public SurveyController surveyController() {
        return new SurveyController();
    }

    @Bean
    public ExampleController exampleController() {
        return new ExampleController();
    }
}
