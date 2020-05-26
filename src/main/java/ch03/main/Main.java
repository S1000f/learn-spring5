package ch03.main;

import ch03.*;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static AnnotationConfigApplicationContext ctx = null;

    public static void main(String[] args) throws IOException {
        ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("input command: ");
            String command = reader.readLine();
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("exit...");
                break;
            }

            if(command.startsWith("new")) {
                processNewCommand(command.split(" "));
            } else if(command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
            } else if(command.equals("list")) {
                processListCommand();
            } else if(command.startsWith("info ")) {
                processInfoCommand(command.split(" "));
            } else {
                printHelp();
            }
        }

        ctx.close();

    }

    private static void processNewCommand(String[] arg) {
        if(arg.length !=5 ) {
            printHelp();
            return;
        }

        MemberRegisterService registerService =
                ctx.getBean(MemberRegisterService.class);
        RegisterRequest request = new RegisterRequest();
        request.setEmail(arg[1]);
        request.setName(arg[2]);
        request.setPassword(arg[3]);
        request.setConfirmPassword(arg[4]);

        if(!request.isPasswordEqualToConfirmPassword()) {
            System.out.println("incorrect password...\n");
            return;
        }
        try {
            registerService.regist(request);
            System.out.println("registered...\n");
        }catch (DuplicateMemberException e) {
            System.out.println("the email already exists...\n");
        }
    }

    private static void processChangeCommand(String[] arg) {
        if(arg.length != 4) {
            printHelp();
            return;
        }

        ChangePasswordService changePasswordService =
                ctx.getBean(ChangePasswordService.class);
        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("password changed...\n");
        } catch (MemberNotFoundException e) {
            System.out.println("doesn't exist email...\n");
        }  catch (WrongPasswordException e) {
            System.out.println("incorrect information input...");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("check following command set-list");
        System.out.println("---command list---");
        System.out.println("new [email] [name] [password] [password again]");
        System.out.println("change [email] [current password] [new password]");
        System.out.println("list");
        System.out.println("info [email]");
        System.out.println("version");
        System.out.println("exit");
        System.out.println();
    }

    private static void processListCommand() {
        MemberListPrinter listPrinter =
                ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void processInfoCommand(String[] arg) {
        if(arg.length != 2) {
            printHelp();
            return;
        }

        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(arg[1]);
    }

    private static void processVersionCommand() {
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }
}
