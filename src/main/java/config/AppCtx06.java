package config;

import ch06.Client;
import ch06.Client2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx06 {

    @Bean
    public Client client() {
        Client client = new Client();
        client.setHost("host");
        return client;
    }

    @Bean(initMethod = "connect", destroyMethod = "close")
    public Client2 client2() {
        Client2 client2 = new Client2();
        client2.setHost("host");
        return client2;
    }
}
