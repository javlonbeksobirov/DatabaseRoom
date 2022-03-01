package com.b12game.databaseroom.manager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.b12game.databaseroom.database.UserDao;
import com.b12game.databaseroom.model.User;

@Database(entities = {User.class},version = 1)
public abstract class RoomManager extends RoomDatabase {

    public abstract UserDao userDao();
    private static RoomManager INSTANCE;

    public static RoomManager getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (RoomManager.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        RoomManager.class,"app_db")
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return INSTANCE;
    }
}


