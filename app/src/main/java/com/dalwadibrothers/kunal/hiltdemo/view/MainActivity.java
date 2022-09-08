package com.dalwadibrothers.kunal.hiltdemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.dalwadibrothers.kunal.hiltdemo.ApiCalls;
import com.dalwadibrothers.kunal.hiltdemo.R;
import com.dalwadibrothers.kunal.hiltdemo.SomeClass;
import com.dalwadibrothers.kunal.hiltdemo.data.User;
import com.dalwadibrothers.kunal.hiltdemo.databinding.MainActivityBinding;
import com.dalwadibrothers.kunal.hiltdemo.di.Https;
import com.dalwadibrothers.kunal.hiltdemo.di.NetworkModule;
import com.dalwadibrothers.kunal.hiltdemo.viewmodel.MainActivityViewModel;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    //field dependency injection
    @Inject
    SomeClass someClass;

//    private final MainActivityViewModel mainActivityViewModel;

    private MainActivityBinding mainActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivityBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        final MainActivityViewModel mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {

            }
        });



        Log.d(TAG, "onCreate: " + someClass.doSomething());
        Log.d(TAG, "onCreate: " + someClass.doSomeOtherThing());
//        Log.d(TAG, "onCreate: " + someClass.doRandomThing());

        tryGetFunction();

    }

    public void tryGetFunction()
    {

        new Handler().post(new Runnable() {
            @Override
            public void run() {

                try {
                    @Https
                    ApiCalls apiCalls = NetworkModule.provideRetrofitHttps().create(ApiCalls.class);
                    Call<ResponseBody> responseBodyCall = apiCalls.makeGETServiceCall("/about");
                    Response<ResponseBody> execute = responseBodyCall.execute();
                    Log.d(TAG, "run: " + execute.body().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }
}