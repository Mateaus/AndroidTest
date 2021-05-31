package com.example.hiltsandbox.di;

import com.example.hiltsandbox.adapter.ToDoAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RecyclerViewAdapterModule {

    @Singleton
    @Provides
    public ToDoAdapter provideToDoAdapter() {
        return new ToDoAdapter();
    }
}
