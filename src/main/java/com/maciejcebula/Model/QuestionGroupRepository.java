package com.maciejcebula.Model;

import com.maciejcebula.Entity.Question;
import com.maciejcebula.Entity.QuestionGroup;
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
public class QuestionGroupRepository {

    private JdbcTemplate jdbc;

    public QuestionGroupRepository() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        this.jdbc = new JdbcTemplate(driverManagerDataSource);
    }

    public List<QuestionGroup> findAllByQuestionaireID(int QuestID) {
        return jdbc.query("Select idg,questionGroupName,ida,isMetrics from questionGroups where ida="+ Integer.toString(QuestID)+";", new RowMapper<QuestionGroup>() {
            public QuestionGroup mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                QuestionGroup questionGroup = new QuestionGroup();
                questionGroup.setIdg(rs.getInt(1));
                questionGroup.setQuestionGroupName(rs.getString(2));
                questionGroup.setIda(rs.getInt(3));
                questionGroup.setIsMetrics(rs.getBoolean(4));
                return questionGroup;
            }
        });
    }
    public List<QuestionGroup> findAll() {
        return jdbc.query("Select idg,questionGroupName,ida,isMetrics from questionGroups;", new RowMapper<QuestionGroup>() {
            public QuestionGroup mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                QuestionGroup questionGroup = new QuestionGroup();
                questionGroup.setIdg(rs.getInt(1));
                questionGroup.setQuestionGroupName(rs.getString(2));
                questionGroup.setIda(rs.getInt(3));
                questionGroup.setIsMetrics(rs.getBoolean(4));
                return questionGroup;
            }
        });
    }
    public void addNewQuestionGroup(QuestionGroup questionGroup) {
        jdbc.update("INSERT into questionGroups(questionGroupName,ida,isMetrics) values (?,?,?);"
                , questionGroup.getQuestionGroupName(),questionGroup.getIda(),questionGroup.getIsMetrics());
    }
}