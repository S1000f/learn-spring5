package ch11.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class SurveyController {

    @GetMapping
    public ModelAndView form() {
        List<Question> questions = createQuestions();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("questions", questions);
        modelAndView.setViewName("survey/surveyForm");

        return modelAndView;
    }

    private List<Question> createQuestions() {
        Question q1 = new Question("What is your speciality?", Arrays.asList("Server", "Front", "Fullstack"));
        Question q2 = new Question("What is your favorite editor?", Arrays.asList("eclipse", "IntelliJ IDEA",
                "Sublime Text"));
        Question q3 = new Question("Any comment you want...");

        return Arrays.asList(q1,q2,q3);
    }

    @PostMapping
    public String submit(@ModelAttribute("ansData") AnsweredData data) {
        return "survey/submitted";
    }
}
