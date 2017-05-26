package com.maciejcebula.Model;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Entity.Questionaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maciej Cebula on 25.05.2017.
 */
@Repository
public class QuestionRepository {

    private JdbcTemplate jdbc;

    public QuestionRepository() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        this.jdbc = new JdbcTemplate(driverManagerDataSource);
    }

    public List<Question> findAllByQuestionaireID(int QuestID) {
        return jdbc.query("select idp, name, ida from questions q where q.ida="+ Integer.toString(QuestID)+";", new RowMapper<Question>() {
            public Question mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Question question = new Question();
                question.setIdp(rs.getInt(1));
                question.setName(rs.getString(2));
                question.setIda(rs.getInt(3));
                return question;
            }
        });
    }
    public void addNewAnkieta(Question question) {
        jdbc.update("INSERT into questions(name, ida) values (?,?)"
                , question.getName(), question.getIda());
    }
}
