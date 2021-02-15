package com.pavelgostudy.startandroid.covisor;

import android.app.Application;

import com.pavelgostudy.startandroid.covisor.api.ApiService;
import com.pavelgostudy.startandroid.covisor.repository.AuthRepository;
import com.pavelgostudy.startandroid.covisor.repository.GroupedContactsRepository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    public AuthRepository authRepository;
    public GroupedContactsRepository groupedContactsRepository;
    public ApiService authService;
    private static MyApp singleton;
    private boolean isLogged;

    public static MyApp getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        initRetrofit();
        initRepositories();
    }

    private void initRepositories() {
        authRepository = new AuthRepository(authService);
        groupedContactsRepository = new GroupedContactsRepository(authService);
    }

    private void initRetrofit() {
        authService =  new Retrofit.Builder()
                .baseUrl("https://timesur.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
