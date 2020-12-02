package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class UserFragment extends Fragment {       //класс для фрагмента со списком
    private User user;
    private TextView userName_userLastname_View;

    @Override
    public void OnCreate(Bundle savedInstanceState) {     //переопределение метода OnCreate
        super.onCreate(savedInstanceState);
        user = new User();
        user.setUserName("Ivan");
        user.setUserLastName("Ivanov");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup Container, Bundle savedInstanceState) {  //создание компонентов внутри фрагмента
        //LayoutInflater - наполняет активность фрагментом
        View view = inflater.inflate(R.layout.fragment_user,container,false);  //указываем, какую активность наполняем нашей view
        return view;
        userName_userLastname_View = view.findViewById(R.id.userName_userLastname_View);       //ищем нужный элемент на компоненте View
        String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: "+user.getUserLastName();//склеиваем фио
        userName_userLastname_View.setText(userName); //кладем в переменную
    }
}
