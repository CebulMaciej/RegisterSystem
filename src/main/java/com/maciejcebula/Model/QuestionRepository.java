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
        return jdbc.query("Select q.idp,q.questionContent,q.idg,q.idt,q.isFirst from questions q inner join questiongroups qg on q.idg=qg.idg inner join questionaries qu on qg.ida=qu.ida where qu.ida = "+ Integer.toString(QuestID)+";", new RowMapper<Question>() {
            public Question mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Question question = new Question();
                question.setIdp(rs.getInt(1));
                question.setQuestionContent(rs.getString(2));
                question.setIdg(rs.getInt(3));
                question.setIdt(rs.getInt(4));
                question.setIsFirst(rs.getBoolean(5));
                return question;
            }
        });
    }
    public List<Question> findAllByGroupID(int GroupID) {
        return jdbc.query("Select q.idp,q.questionContent,q.idg,q.idt,q.isFirst from questions q inner join questiongroups qg on q.idg=qg.idg where qg.idg = "+ Integer.toString(GroupID)+";", new RowMapper<Question>() {
            public Question mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                Question question = new Question();
                question.setIdp(rs.getInt(1));
                question.setQuestionContent(rs.getString(2));
                question.setIdg(rs.getInt(3));
                question.setIdt(rs.getInt(4));
                question.setIsFirst(rs.getBoolean(5));
                return question;
            }
        });
    }
    public void addNewQuestion(Question question) {
        jdbc.update("INSERT into questions(questionContent, idg, idt,isFirst) values (?,?,?,?);"
                , question.getQuestionContent(),question.getIdg(),question.getIdt(),question.getIsFirst());
    }
}
