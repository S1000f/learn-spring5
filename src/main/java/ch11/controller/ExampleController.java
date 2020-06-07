package ch11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExampleController {

    @GetMapping("/example/login")
    public String login(Model model) {
        List<String> loginTypes = new ArrayList<>();
        loginTypes.add("normal");
        loginTypes.add("member");
        loginTypes.add("head hunters");

        model.addAttribute("loginTypes", loginTypes);
        return "example/login";
    }
}
