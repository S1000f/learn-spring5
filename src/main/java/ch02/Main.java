package ch02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
        Greetings g = ctx.getBean("greetings", Greetings.class);
        String message = g.greet("Spring5");
        System.out.println(message);
        ctx.close();
    }
}
