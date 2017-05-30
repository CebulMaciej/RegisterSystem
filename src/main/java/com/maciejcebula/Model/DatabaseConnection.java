package com.maciejcebula.Model;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 * Created by Maciej Cebula on 30.05.2017.
 */
@Repository
public class DatabaseConnection {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public DatabaseConnection(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        this.jdbcTemplate=new JdbcTemplate(driverManagerDataSource);
    }
}
