package ch11.controller;

import ch11.DuplicateMemberException;
import ch11.MemberRegisterService;
import ch11.RegisterRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private MemberRegisterService memberRegisterService;

    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/register/step1")
    public String handleStep1() {
        return "register/step1";
    }

    @PostMapping("/register/step2")
    public String handlerStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agreeParam,
                               RegisterRequest registerRequest) {
        if(!agreeParam) {
            return "register/step1";
        }

        return "register/step2";
    }

    @GetMapping("register/step2")
    public String handleStep2Get() {
        return "redirect:/register/step1";
    }

    @PostMapping("/register/step3")
    public String handleStep3(@Valid RegisterRequest registerRequest, Errors errors) {
        if(errors.hasErrors()) {
            return "register/step2";
        }
        try {
            memberRegisterService.regist(registerRequest);

            return "register/step3";
        } catch (DuplicateMemberException e) {
            errors.rejectValue("email", "duplicate");

            return "register/step2";
        }
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(new RegisterRequestValidator());
//    }
}
