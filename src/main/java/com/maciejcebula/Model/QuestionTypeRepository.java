package com.maciejcebula.Model;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Entity.QuestionType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maciej Cebula on 27.05.2017.
 */
@Repository
public class QuestionTypeRepository {

    private JdbcTemplate jdbc;

    public QuestionTypeRepository() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        this.jdbc = new JdbcTemplate(driverManagerDataSource);
    }
    public List<QuestionType> findAllQuestionTypes() {
        return jdbc.query("select idt,typeName from QuestionTypes;", new RowMapper<QuestionType>() {
            public QuestionType mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                QuestionType questionType = new QuestionType();
                questionType.setIdt(rs.getInt(1));
                questionType.setTypeName(rs.getString(2));
                return questionType;
            }
        });
    }
}