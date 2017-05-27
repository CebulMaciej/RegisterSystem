package com.maciejcebula.Model;

import com.maciejcebula.Entity.ClosedAnswer;
import com.maciejcebula.Entity.Question;
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
public class ClosedAnswerRepository {

        private JdbcTemplate jdbc;

        public ClosedAnswerRepository() {
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
            driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
            driverManagerDataSource.setUsername("postgres");
            driverManagerDataSource.setPassword("postgres");
            this.jdbc = new JdbcTemplate(driverManagerDataSource);
        }

        public List<ClosedAnswer> findAllClosedByQuestionID(int QuestID) {
            return jdbc.query("select c.idca,c.caContent from closedAnswers c inner join answers a on c.idca=a.idca inner join questions q on a.idp=q.idp where q.idp="+QuestID+";", new RowMapper<ClosedAnswer>() {
                public ClosedAnswer mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    ClosedAnswer closedAnswer = new ClosedAnswer();
                    closedAnswer.setIdca(rs.getInt(1));
                    closedAnswer.setCaContent(rs.getString(2));
                    return closedAnswer;
                }
            });
        }
        public void addNewClosedAnswer(ClosedAnswer closedAnswer) {
            jdbc.update("INSERT into closedAnswers(caContent) values (?,?);"
                    ,closedAnswer.getCaContent());
        }
    }
