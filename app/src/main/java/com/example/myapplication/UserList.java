package com.example.myapplication;


import java.util.ArrayList;
import java.util.List;

// Синглетный класс (может быть создан только один объект)
public class UserList {
    private static UserList userList;
    private List users;
    public static UserList get(){      //метод,не позв.создать другой список
        if(userList == null){
            userList = new UserList();
        }
        return userList;
    }
    private UserList(){        //конструктор для генерации юзеров
        users = new ArrayList();
        for(int i=0; i<100; i++){
            User user = new User();
            user.setUserName("ИМЯ_"+i);
            user.setUserLastName("Фамилия_"+i);
            users.add(user);
        }
    }
    public List getUsers(){
        return users;
    }
}