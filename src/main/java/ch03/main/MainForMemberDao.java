package ch03.main;

import ch03.Member;
import ch03.MemberDao;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainForMemberDao {
    private static MemberDao memberDao;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppCtx.class);

        memberDao = context.getBean(MemberDao.class);

        selectAll();
        updateMember();
        insertMember();

        context.close();
    }

    private static void selectAll() {
        System.out.println("----- selectAll");
        int total = memberDao.count();
        System.out.println("Total data: " + total);
        List<Member> members = memberDao.selectAll();
        for(Member m : members) {
            System.out.println(m.getId() + " : " + m.getEmail() + " : " + m.getName());
        }
    }

    private static void updateMember() {
        System.out.println("----- updateMember");
        Member member = memberDao.selectByEmail("dohp.kim@gmail.com");
        String oldPw = member.getPassword();
        String newPw = Double.toHexString(Math.random());
        member.changePassword(oldPw, newPw);

        memberDao.update(member);
        System.out.println("Password changed :" + oldPw + " -> " + newPw);
    }

    private static DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("MMddHHmmss");

    private static void insertMember() {
        System.out.println("----- insertMember");

        String prefix = formatter.format(LocalDateTime.now());
        Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
        memberDao.insert(member);
        System.out.println(member.getId() + " Data inserted");
    }
}
