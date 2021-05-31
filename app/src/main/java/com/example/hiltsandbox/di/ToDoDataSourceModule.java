package com.example.hiltsandbox.di;

import com.example.hiltsandbox.di.qualifiers.LocalToDoDataSource;
import com.example.hiltsandbox.di.qualifiers.RemoteToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoLocalDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoRemoteDataSource;
import com.example.hiltsandbox.network.PlaceholderService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class ToDoDataSourceModule {

    @Singleton
    @LocalToDoDataSource
    @Provides
    public ToDoDataSource provideToDoLocalDataSource() {
        return new ToDoLocalDataSource();
    }

    @Singleton
    @RemoteToDoDataSource
    @Provides
    public ToDoDataSource provideToDoRemoteDataSource(
            PlaceholderService placeholderService
    ) {
        return new ToDoRemoteDataSource(placeholderService);
    }
}
