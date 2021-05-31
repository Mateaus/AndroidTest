package com.example.hiltsandbox.fakedi;

import com.example.hiltsandbox.fragments.todo.ToDoDataSource;

import java.util.ArrayList;

public class FakeToDoDataSource implements ToDoDataSource {



    @Override
    public void getToDo(GetToDoCallback callback) {
        callback.onSuccess(new ArrayList<>());
        callback.onError();
        callback.onNetworkError();
    }
}
