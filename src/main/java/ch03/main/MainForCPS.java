package ch03.main;

import ch03.ChangePasswordService;
import ch03.MemberNotFoundException;
import ch03.WrongPasswordException;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainForCPS {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx.class);

        ChangePasswordService cps =
                ctx.getBean("changePasswordService", ChangePasswordService.class);

        try {
            cps.changePassword("dohp.kim@gmail.com", "1111", "1234");
            System.out.println("password changed successfully");
        } catch (MemberNotFoundException e) {
            System.out.println("there is no such a member data...");
        } catch (WrongPasswordException e) {
            System.out.println("old password is incorrect...");
        }

        ctx.close();
    }
}
