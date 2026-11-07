package kz.bekzataitymov.projects.markdownapp.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean
    @ConfigurationProperties("db")
    public DatabaseProperties databaseProperties(){
        return new DatabaseProperties();
    }

    @Bean
    public DataSource dataSource(DatabaseProperties properties){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDriver());
        dataSource.setJdbcUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }
}
