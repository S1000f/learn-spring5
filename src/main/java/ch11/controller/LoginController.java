package ch11.controller;

import ch11.AuthInfo;
import ch11.AuthService;
import ch11.WrongPasswordException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String form(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false)Cookie rCookie) {
        if(rCookie != null) {
            loginCommand.setEmail(rCookie.getValue());
            loginCommand.setRememberEmail(true);
        }
        return "login/loginForm";
    }

    @PostMapping
    public String login(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if(errors.hasErrors()) {
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
            session.setAttribute("authInfo", authInfo);

            Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
            rememberCookie.setPath("/");
            if(loginCommand.isRememberEmail()) {
                rememberCookie.setMaxAge(60 * 60 * 24 * 2);
            } else {
                rememberCookie.setMaxAge(0);
            }
            response.addCookie(rememberCookie);

            return "login/loginSuccess";
        } catch (WrongPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
}
