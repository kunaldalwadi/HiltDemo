package com.dalwadibrothers.kunal.hiltdemo.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dalwadibrothers.kunal.hiltdemo.data.User;
import com.dalwadibrothers.kunal.hiltdemo.data.UserRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

public class MainActivityViewModel extends ViewModel {

    private final UserRepository userRepository;

    private final MutableLiveData<List<User>> userMutableLiveData = new MutableLiveData<>();


    public MainActivityViewModel(Application application) {
        userRepository = new UserRepository(application);
    }


    public LiveData<List<User>> getUserLiveData() {
       return userMutableLiveData;
    }

    public void insertUser(User user) {
        userRepository.insertUser(user);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }
}
