package com.dalwadibrothers.kunal.hiltdemo.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;


/*
1. Make a Class that extends RoomDatabase (Which will be the class that handles database throughout the application)
 and make it abstract, which means you dont have to implement the methods
2. Create/Generate the RoomDatabase. (by using Room.databaseBuilder().addCallback().build())
3. Make instance of this AppDatabase Class which extends RoomDatabase as static and synchronized (so there is only one instance of the database at one time making changes in the database.)
4. Define RoomDatabase callback it should also be private and static
5. There is normally only one database class in an application, which needs reference to all DAO's of the application
    DAO's belong to each table and database is a collection of tables so we need to reference all Dao's here.
 */


@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao getUserDao();

    private static AppDatabase databaseInstance;

    public static synchronized AppDatabase getDatabaseInstance(Context context)
    {
        if (databaseInstance == null) {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "User_Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return databaseInstance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            /*

            On a brand new creation of the database, if you want to add some entries to the db so that we have some data to show to the screen
            we can do that here, it needs to be done on a separate thread or asyncTask

             */



        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
        }
    };
}
