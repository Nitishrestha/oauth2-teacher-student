package com.nitish.self.teacherstudentmanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.database.driverClassName}")
    private String dbDriverClassName;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);

        return dataSource;
    }

    /*
    * This is used to store generated token
    * if JdbcTokenStore is used, it will save the token in the given datasource
    * if inMemoryTokenStore is chosen, it will store the token in the memory
    * */
    @Bean
    public TokenStore tokenStore() {
        //return new InMemoryTokenStore();
        return new JdbcTokenStore(dataSource());
    }
}