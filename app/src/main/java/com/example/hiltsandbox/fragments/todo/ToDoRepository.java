package com.example.hiltsandbox.fragments.todo;

import com.example.hiltsandbox.model.ToDo;

import java.util.List;

public class ToDoRepository implements ToDoDataSource {

    private ToDoDataSource localToDoDataSource;
    private ToDoDataSource remoteToDoDataSource;

    public ToDoRepository(
            ToDoDataSource localToDoDataSource,
            ToDoDataSource remoteToDoDataSource
    ) {
        this.localToDoDataSource = localToDoDataSource;
        this.remoteToDoDataSource = remoteToDoDataSource;
    }

    @Override
    public void getToDo(GetToDoCallback callback) {
        remoteToDoDataSource.getToDo(new GetToDoCallback() {
            @Override
            public void onSuccess(List<ToDo> toDos) {
                callback.onSuccess(toDos);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onNetworkError() {

            }
        });
    }
}
