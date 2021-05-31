package com.example.hiltsandbox.network;

import com.example.hiltsandbox.model.ToDo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlaceholderService {

    @GET("todos")
    Call<List<ToDo>> getTodos();
}
