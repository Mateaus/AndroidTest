package com.example.hiltsandbox.fragments.todo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.hiltsandbox.model.ToDo;
import com.example.hiltsandbox.network.PlaceholderService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ToDoRemoteDataSource implements ToDoDataSource {

    private static final String TAG = "ToDoRemoteDataSource";

    private final PlaceholderService placeholderService;

    public ToDoRemoteDataSource(PlaceholderService placeholderService) {
        this.placeholderService = placeholderService;
    }

    @Override
    public void getToDo(GetToDoCallback callback) {
        Log.d(TAG, "getToDo: request received.");
        placeholderService.getTodos().enqueue(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(@NonNull Call<List<ToDo>> call,
                                   @NonNull Response<List<ToDo>> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ToDo>> call,
                                  @NonNull Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage(), t.getCause());
                callback.onNetworkError();
            }
        });
    }
}
