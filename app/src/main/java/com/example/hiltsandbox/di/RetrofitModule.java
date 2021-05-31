package com.example.hiltsandbox.di;

import com.example.hiltsandbox.network.PlaceholderService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class RetrofitModule {

    @Singleton
    @Provides
    public Gson provideGsonBuilder() {
        return new GsonBuilder()
                .create();
    }

    @Singleton
    @Provides
    public Retrofit.Builder provideRetrofitBuilder(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    @Singleton
    @Provides
    public PlaceholderService providePlaceholderService(@NotNull Retrofit.Builder retrofitBuilder) {
        return retrofitBuilder
                .build()
                .create(PlaceholderService.class);
    }
}
