package com.dalwadibrothers.kunal.hiltdemo;

import com.google.gson.Gson;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Annotation;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.components.SingletonComponent;


//https://www.youtube.com/watch?v=dFSv_ErTepY&list=PLgCYzUzKIBE_MUlyvbCiOWsfq0nFgGXQ9&index=6

@InstallIn(SingletonComponent.class)
@Module
class SomeModule {

    @Singleton
    @Provides
    public SomeInterface provideSomeInterface1()
    {
        return new SomeInterfaceImpl1();
    }

    @Singleton
    @Provides
    public Gson provideGson()
    {
        return new Gson();
    }

    @Singleton
    @Provides
    public SomeInterface provideSomeInterface2()
    {
        return new SomeInterfaceImpl2();
    }

}

