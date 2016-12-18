package com.bp.springboot.samples.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by behzad.pirvali on 11/19/16.
 */
@Configuration
public class PersistenceConfig {
    @Bean
    public PropDCSpring propDCSpring() {
        return new PropDCSpring();
    }

    @Bean
    public PropDCFlyway propDCFlyway() {
        return new PropDCFlyway();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        PropDCSpring p = propDCSpring();
        return DataSourceBuilder.create()
                .driverClassName(p.getDriverClassName())
                .url(p.getUrl())
                .username(p.getUser())
                .password(p.getPassword())
                .build();
    }

    @Bean
    @FlywayDataSource
    public DataSource flywayDataSource() {
        PropDCFlyway p = propDCFlyway();
        return DataSourceBuilder.create()
                .driverClassName(p.getDriverClassName())
                .url(p.getUrl())
                .username(p.getUser())
                .password(p.getPassword())
                .build();
    }


}
