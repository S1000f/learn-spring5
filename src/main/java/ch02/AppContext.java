package ch02;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public Greetings greetings() {
        Greetings g = new Greetings();
        g.setFormat("%s, Hello!");
        return g;
    }
}
