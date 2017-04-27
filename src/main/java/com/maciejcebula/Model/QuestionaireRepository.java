package com.maciejcebula.Model;

import com.maciejcebula.Entity.Ankieta;
import com.maciejcebula.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maciej Cebula on 27.04.2017.
 */
public class AnkietaRepository {
        private JdbcTemplate jdbc;

        public AnkietaRepository() {
            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
            driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
            driverManagerDataSource.setUsername("postgres");
            driverManagerDataSource.setPassword("postgres");
            this.jdbc = new JdbcTemplate(driverManagerDataSource);
        }

        public List<Ankieta> findAll() {
            return jdbc.query("select ida, Nazwa, id_ from questionaire", new RowMapper<Ankieta>() {
                public Ankieta mapRow(ResultSet rs, int rowNum)
                        throws SQLException {
                    Ankieta ankieta = new Ankieta();
                    ankieta.setIda(rs.getInt(1));
                    ankieta.setNazwa(rs.getString(2));
                    ankieta.setId_(rs.getInt(3));
                    return ankieta;
                }
            });
        }

        public void addNewAnkieta(Ankieta ankieta) {
            jdbc.update("INSERT into questionaire(Nazwa, id_) values (?,?)"
                        , ankieta.getNazwa(),ankieta.getId_());
        }
    }
