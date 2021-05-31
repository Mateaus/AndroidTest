package com.example.hiltsandbox.fragments.todo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.example.hiltsandbox.model.ToDo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class ToDoViewModel extends ViewModel {

    private static final String TAG = "ToDoViewModel";

    private MutableLiveData<List<ToDo>> todoList = new MutableLiveData<>();

    private final ToDoRepository toDoRepository;

    @Inject
    public ToDoViewModel(
            SavedStateHandle savedStateHandle,
            ToDoRepository toDoRepository
    ) {
        this.toDoRepository = toDoRepository;
    }

    public void sendToDoListRequest() {
        toDoRepository.getToDo(new ToDoDataSource.GetToDoCallback() {
            @Override
            public void onSuccess(List<ToDo> toDos) {
                Log.v(TAG, "onSuccess");

                todoList.postValue(toDos);
            }

            @Override
            public void onError() {
                Log.v(TAG, "onError");
            }

            @Override
            public void onNetworkError() {
                Log.v(TAG, "onNetworkError");
            }
        });
    }

    public MutableLiveData<List<ToDo>> getTodoList() {
        return todoList;
    }
}
