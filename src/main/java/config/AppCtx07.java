package config;

import ch07.Calculator;
import ch07.RecCalculator;
import ch07.aspect.ExecTimeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AppCtx07 {

    @Bean
    public ExecTimeAspect execTimeAspect() {
        return new ExecTimeAspect();
    }

    @Bean
    public Calculator calculator() {
        return new RecCalculator();
    }
}
