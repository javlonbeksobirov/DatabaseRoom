package com.b12game.databaseroom.database;

import android.app.Application;

import com.b12game.databaseroom.manager.RoomManager;
import com.b12game.databaseroom.model.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao;

    public UserRepository(Application application){
        RoomManager db = RoomManager.getDatabase(application);
        userDao = db.userDao();
    }

    public List<User> getUsers(){
        return userDao.getusers();
    }

    public void saveUser(User user){
        userDao.saveUser(user);
    }
}
