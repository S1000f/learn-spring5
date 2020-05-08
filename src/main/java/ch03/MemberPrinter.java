package ch03;

public class MemberPrinter {

    public void print(Member member) {
        System.out.printf(
                "user info: id=%d, e-mail=%s, name=%s, registerDate=%tF\n",
                member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
    }
}
