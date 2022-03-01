package com.b12game.databaseroom.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.b12game.databaseroom.model.User;
import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long saveUser(User user);

    @Query("select * from user_table")
    List<User> getusers();
}
