package com.maciejcebula.Model;

import com.maciejcebula.Entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Maciej Cebula on 25.04.2017.
 */
@Repository
public class UserRepository {
    private JdbcTemplate jdbc;

    public UserRepository(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/mydb");
        driverManagerDataSource.setUsername("postgres");
        driverManagerDataSource.setPassword("postgres");
        this.jdbc = new JdbcTemplate(driverManagerDataSource);
    }
    public List<User> findAll(){
        return jdbc.query("select id_, login, password, firstName, lastName, phoneNumber, emailAddress from users",new RowMapper<User>(){
            public User mapRow(ResultSet rs, int rowNum)
                    throws SQLException {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setFirstName(rs.getString(4));
                user.setLastName(rs.getString(5));
                user.setPhoneNumber(rs.getString(6));
                user.setEmailAddress(rs.getString(7));
                return user;
            }
        });
    }
    public boolean register(User user){
        if(this.registerTry(user.getLogin())) {
            jdbc.update("INSERT into users(login,password, firstName, lastName, phoneNumber, emailAddress) values (?,?,?,?,?,?)"
                    , user.getLogin(), user.getPassword(),user.getFirstName(),user.getLastName(),user.getPhoneNumber(),user.getEmailAddress());
            return true;
        }
        else
            return false;
    }
    public User loginTry(User user){
        List<User> users = this.findAll();
        for (User us : users){
           if(us.getLogin().equals(user.getLogin())&&us.getPassword().equals(user.getPassword())){
               return us;
           }
        }
        return null;
    }
    private boolean registerTry(String login){
        List<User> users = this.findAll();
        for (User us : users){
            if(login.equals(us.getLogin())){
                return false;
            }
        }
        return true;
    }
    public void updateUser(User user){
        /*this.jdbc.update("Update Users SET password="
                +user.getPassword()+","
                +"firstName="+user.getFirstName()+","
                +"lastName=" + user.getLastName()+ ","
                +"phoneNumber=" + user.getPhoneNumber()+","
                +"emailAddress=" + user.getEmailAddress()+ " "
                +"Where Users.id_="+user.getId());
                */
        this.jdbc.update("update users set password=?, firstName=?, lastName=?, phoneNumber=?, emailAddress=? where users.id_=?",
                user.getPassword(),user.getFirstName(),user.getLastName(),user.getPhoneNumber(),user.getEmailAddress(),user.getId());
    }
}
