package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Trying to get rid of the exceptions when I launch the app.
 * 
 * I don't think this makes it better, but it also doesn't make it worse.
 * 
 */
@Configuration
public class DataSourceConfig 
{

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username", "")); // SQLite does not need username
        dataSource.setPassword(env.getProperty("spring.datasource.password", "")); // SQLite does not need password
        return dataSource;
    }
}
