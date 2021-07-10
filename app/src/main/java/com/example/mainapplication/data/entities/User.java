package com.example.mainapplication.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.mainapplication.objects.Person;

import java.util.Date;


@Entity
public abstract class User
{
    public User()
    {

    }
    public User(Person person)
    {
        userName = person.getUsername();
        name = person.getName();
        lastname = person.getLastName();
        email = person.getEmail();
        password = person.getPassword();
        image = person.getImage();
        birthday = person.getBirthday();
    }

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "username")
    public String userName;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "lastname")
    public String lastname;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "birthday")
    public String birthday;
}
