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
    public boolean addUserToDataBase(User user) {
        return repo.register(user);
    }
    public void updateUser(User user){
        this.repo.updateUser(user);
    }
    public User login(User user){
        List<User> list = this.repo.findUser(user);
        for (User us: list) {
            if(us.getLogin().equals(user.getLogin())&&us.getPassword().equals(user.getPassword())){
                return us;
            }
        }
        return null;
    }
}
