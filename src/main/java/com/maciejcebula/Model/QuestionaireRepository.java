package com.maciejcebula.Model;

import com.maciejcebula.Entity.Questionaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
@Repository
public class QuestionaireRepository {
        private DatabaseConnection data;

        @Autowired
        public QuestionaireRepository(DatabaseConnection databaseConnection) {
            this.data=databaseConnection;
        }

        public List<Questionaire> findAll() {
            return data.getJdbcTemplate().query("select ida, name, id_ from questionaries", new RowMapper<Questionaire>() {
                public Questionaire mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Questionaire questionaire = new Questionaire();
                    questionaire.setIda(rs.getInt(1));
                    questionaire.setNazwa(rs.getString(2));
                    questionaire.setId_(rs.getInt(3));
                    return questionaire;
                }
            });
        }

        public void addNewAnkieta(Questionaire questionaire) {
            data.getJdbcTemplate().update("INSERT into questionaries(name, id_) values (?,?)"
                        , questionaire.getNazwa(), questionaire.getId_());
        }
        public List<Questionaire> findUsersAllQuestionaries(int id){
            return data.getJdbcTemplate().query("select ida,name from questionaries,users where questionaries.id_=users.id_ and users.id_="+Integer.toString(id)+";", new RowMapper<Questionaire>() {
                public Questionaire mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Questionaire questionaire = new Questionaire();
                    questionaire.setIda(rs.getInt(1));
                    questionaire.setNazwa(rs.getString(2));
                    questionaire.setId_(id);
                    return questionaire;
                }
            });
        }
        public void deleteQuestionaire(int id){
            data.getJdbcTemplate().update("Delete from questionaries where questionaries.ida=" + Integer.toString(id));
        }
    }
