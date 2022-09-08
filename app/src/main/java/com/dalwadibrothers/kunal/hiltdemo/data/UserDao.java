package com.dalwadibrothers.kunal.hiltdemo.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/*
1. Each Table gets its own Dao
2. Each Table/Dao has its own repository.
3. DAO is an interface that provides an abstraction layer to access all SQL functions.
4. make DAO as an interface and annotate the interface with @Dao
 */

@Dao
public interface UserDao {

    @Insert
    public void insertUser(User user);

    @Delete
    public void deleteUser(User user);

    /*
    we could have just returned List<User> from here as well.
    we have taken the LiveData type of List so that we can just post the live data and UI updates by itself.
     */
    @Query("SELECT * FROM user_table")
    public LiveData<List<User>> getAllUsers();

}
