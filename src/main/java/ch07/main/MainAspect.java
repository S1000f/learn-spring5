package ch07.main;

import ch07.Calculator;
import config.AppCtx07;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtx07.class);

        Calculator cal = context.getBean("calculator", Calculator.class);
        long fiveFact = cal.factorial(5);
        System.out.println("cal.factorial(5) = " + fiveFact);
        System.out.println(cal.getClass().getName());
        context.close();

    }
}
