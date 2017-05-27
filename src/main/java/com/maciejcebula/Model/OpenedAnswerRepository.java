package com.maciejcebula.Model;

import com.maciejcebula.Entity.ClosedAnswer;
import com.maciejcebula.Entity.OpenedAnswer;
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
public class OpenedAnswerRepository {

    private JdbcTemplate jdbc;

    public OpenedAnswerRepository() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        this.jdbc = new JdbcTemplate(driverManagerDataSource);
    }

    public List<OpenedAnswer> findAllClosedByQuestionID(int QuestID) {
        return jdbc.query("select o.idoa from openedAnswers o inner join answers a on o.idoa=a.idoa inner join questions q on a.idp=q.idp where q.idp="+QuestID+";", new RowMapper<OpenedAnswer>() {
            public OpenedAnswer mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                OpenedAnswer openedAnswer = new OpenedAnswer();
                openedAnswer.setIdoa(rs.getInt(1));
                return openedAnswer;
            }
        });
    }
    public void addNewClosedAnswer(ClosedAnswer closedAnswer) {
        jdbc.update("INSERT into openedAnswers(idca,caContent) values (?,?);"
                , closedAnswer.getIdca(),closedAnswer.getCaContent());
    }
}
