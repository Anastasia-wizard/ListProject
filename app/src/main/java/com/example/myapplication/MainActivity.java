package com.example.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserList userList = UserList.get();
        FragmentManager fragmentManager = getSupportFragmentManager(); //управление отображением фрагментов на экране
    Fragment fragment = new UserFragment(); //создание экземпляра класаа
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment).commit();        //метод помещает объекты на экран
                                                  //fragmentContainer - куда хотим поместить, fragment - что хотим поместить
                                                  //commit() - зафиксировать
    }
}