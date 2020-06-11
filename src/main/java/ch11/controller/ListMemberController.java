package ch11.controller;

import ch11.Member;
import ch11.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ListMemberController {

    @Autowired
    private MemberDao memberDao;

    @RequestMapping("/members")
    public String list(@ModelAttribute("cmd") ListCommand listCommand, Errors errors, Model model) {
        if(errors.hasErrors()) {
            return "member/memberList";
        }
        if(listCommand.getFrom() != null && listCommand.getTo() != null) {
            List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
            model.addAttribute("members", members);
        }

        return "member/memberList";
    }
}
