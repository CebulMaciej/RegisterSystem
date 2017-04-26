package com.maciejcebula.Service;

import com.maciejcebula.Entity.User;
import com.maciejcebula.Model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maciej Cebula on 25.04.2017.
 */
@Service
public class UserService {
    private UserRepository repo;

    @Autowired
    UserService(UserRepository userRepository){
        this.repo=userRepository;
    }
    public List<User> getAllUsers(){
       return repo.findAll();
    }
    public boolean addUserToDataBase(User user){
        return repo.register(user);
    }
    public User login(User user){
        return repo.loginTry(user);
    }
}
