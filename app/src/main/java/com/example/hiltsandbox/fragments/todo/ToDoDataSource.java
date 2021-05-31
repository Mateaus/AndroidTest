package com.example.hiltsandbox.fragments.todo;

import com.example.hiltsandbox.model.ToDo;

import java.util.List;

public interface ToDoDataSource {

    interface GetToDoCallback {

        void onSuccess(List<ToDo> toDos);

        void onError();

        void onNetworkError();
    }

    void getToDo(GetToDoCallback callback);
}
