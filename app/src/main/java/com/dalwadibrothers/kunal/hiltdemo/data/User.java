package com.dalwadibrothers.kunal.hiltdemo.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User extends BaseObservable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int user_id;

    @ColumnInfo(name = "first_name")
    private String firstname;

    @ColumnInfo(name = "last_name")
    private String lastname;

    @ColumnInfo(name = "age")
    private int age;

    public User(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    @Bindable
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
//        notifyPropertyChanged(BR.user_id);
    }

    @Bindable
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
//        notifyPropertyChanged(BR.firstname);
    }

    @Bindable
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
//        notifyPropertyChanged(BR.lastname);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
//        notifyPropertyChanged(BR.age);
    }
}
