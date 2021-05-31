package com.example.hiltsandbox.di;

import com.example.hiltsandbox.di.qualifiers.LocalToDoDataSource;
import com.example.hiltsandbox.di.qualifiers.RemoteToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ToDoRepositoryModule {

    @Singleton
    @Provides
    public ToDoRepository provideToDoRepository(
            @LocalToDoDataSource ToDoDataSource localToDoDataSource,
            @RemoteToDoDataSource ToDoDataSource remoteTodoDataSource
    ) {
        return new ToDoRepository(
                localToDoDataSource,
                remoteTodoDataSource
        );
    }
}
