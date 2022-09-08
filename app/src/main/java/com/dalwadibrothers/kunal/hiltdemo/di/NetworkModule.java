package com.dalwadibrothers.kunal.hiltdemo.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;


//@Qualifier
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Https{}

//@Qualifier
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Http{}

@Module
@InstallIn(SingletonComponent.class)
abstract public class NetworkModule {

    static Retrofit retrofit;

    @Http
    @Singleton
    @Provides
    public static Retrofit provideRetrofitHttp() {
        if (retrofit == null) {
            synchronized (Retrofit.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl("http://localhost")
                        .build();
            }
        }
        return retrofit;
    }

    @Https
    @Singleton
    @Provides
    public static Retrofit provideRetrofitHttps() {
        if (retrofit == null) {
            synchronized (Retrofit.class) {
                retrofit = new Retrofit.Builder()
                        .baseUrl("https://localhost")
                        .build();
            }
        }
        return retrofit;
    }
}


