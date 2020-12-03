package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserListFragment extends Fragment {
    private RecyclerView userRecyclerView;
    private UserAdapter userAdapter;    //переменная для адаптера
    // Метод создаёт компонент View фрагмента из XML разментки
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_user_list,viewGroup,false);  //раздуваем отображение
        userRecyclerView = view.findViewById(R.id.userRecyclerView);      //переменная с RecyclerView.список.Но он не знает как отображать
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));// менеджер, отвечающий за отображение списка.Без него не работает
                                                                                   //LinearLayout - горизонтальные ячейки, построчно

        UserList userList = UserList.get();  //получаем юзерлист
        List<User> users = userList.getUsers();
        userAdapter = new UserAdapter(users);   //принимает на всход список пользователей
        userRecyclerView.setAdapter(userAdapter);  //уст.адаптер для userRecyclerView

        return view;
    }

    private class UserHolder extends RecyclerView.ViewHolder{   //вспомогательный класс Recycler для отображен я эл-тов
        private TextView userItem;            //View компонент
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup){
            super(inflater.inflate(R.layout.list_item_user,viewGroup,false));  //раздуваем list_item_user
            userItem = itemView.findViewById(R.id.userItem);
        }
        public void bind(User user){
            String userName = "Имя: "+user.getUserName()+"\n"+"Фамилия: "+user.getUserLastName()+"\n---------";
            userItem.setText(userName);
        }
    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{    //адаптер
        private List<User> users;                            //список пользователей
        public UserAdapter(List<User> users){
            this.users = users;
        }   //конструктор в который кладем список, прилетающий в адаптер

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {   //создает элемент списка
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new UserHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = users.get(position);
            userHolder.bind(user);
        }

        @Override
        public int getItemCount() {
            return users.size();
        }  //читаем размер коллекции
    }

}
