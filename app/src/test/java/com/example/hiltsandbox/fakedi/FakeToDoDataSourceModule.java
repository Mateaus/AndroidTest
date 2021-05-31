package com.example.hiltsandbox.fakedi;

import com.example.hiltsandbox.di.ToDoDataSourceModule;
import com.example.hiltsandbox.di.ToDoRepositoryModule;
import com.example.hiltsandbox.di.qualifiers.LocalToDoDataSource;
import com.example.hiltsandbox.di.qualifiers.RemoteToDoDataSource;
import com.example.hiltsandbox.fragments.todo.ToDoDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.testing.TestInstallIn;

@Module
@TestInstallIn(
        components = {SingletonComponent.class},
        replaces = {ToDoDataSourceModule.class})
public class FakeToDoDataSourceModule {

    @Singleton
    @LocalToDoDataSource
    @Provides
    public ToDoDataSource providesFakeToDoLocalDataSource() {
        return new FakeToDoDataSource();
    }

    @Singleton
    @RemoteToDoDataSource
    @Provides
    public ToDoDataSource providesFakeToDoRemoteDataSource() {
        return new FakeToDoDataSource();
    }

}
