package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.tomcat.jdbc.pool.DataSource;


@Configuration
public class DbConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("org.mariadb.jdbc.Driver");
        ds.setUrl("jdbc:mariadb://localhost:3306/spring5fs?characterEncoding=utf8");
        ds.setUsername("spring5");
        ds.setPassword("8175");
        ds.setInitialSize(2);
        ds.setMaxActive(10);

        return ds;
    }
}
