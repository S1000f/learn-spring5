package ch03.main;

import ch06.Client;
import config.AppCtx06;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.IOException;

public class MainForCh06 {

    public static void main(String[] args) throws IOException {
        AbstractApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx06.class);

        Client client = ctx.getBean(Client.class);
        client.send();

        ctx.close();
    }
}
