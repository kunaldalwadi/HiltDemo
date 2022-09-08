package com.dalwadibrothers.kunal.hiltdemo.data;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    /*
        1. Repository will need an object of DAO to access DAO
        2. All Dao's need to be referenced in the Repository. Each Table should have its own repository to keep separation of concerns in check.
        3. getDao() function is an abstract function that we wrote in AppDatabase class (why? because userDao is going to be accessed by both Database as well as Repository.)
        4. to get the userDao reference here we will need to create the object of AppDatabase first.
        5. we will pass the appliation as the ccontext BECAUSE we need the app database to be available through the life time of the application.

        6. Repository should implement all the methods in their respective DAO.
     */

    private UserDao userDao;

    public UserRepository(Application application) {
        AppDatabase databaseInstance = AppDatabase.getDatabaseInstance(application);
        userDao = databaseInstance.getUserDao();
    }

    public LiveData<List<User>> getUserListLiveData() {
        return userDao.getAllUsers();
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
