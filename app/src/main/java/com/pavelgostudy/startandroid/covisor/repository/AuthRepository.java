package com.pavelgostudy.startandroid.covisor.repository;

import android.content.SharedPreferences;
import android.util.Log;

import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.api.ApiService;
import com.pavelgostudy.startandroid.covisor.model.auth.AuthRq;
import com.pavelgostudy.startandroid.covisor.model.auth.AuthRs;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private ApiService apiService;

    public AuthRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getUserData(String login, String password, GetAuthCallBack callBack) {
        AuthRq rq = new AuthRq();
        rq.setUsername(login);
        rq.setPassword(password);
        apiService.authenticateUser(rq).enqueue(new Callback<AuthRs>() {
            @Override
            public void onResponse(Call<AuthRs> call, Response<AuthRs> response) {
                if (response.isSuccessful()) {
                    Log.d("network", "auth data received: " + response.body());
                    MyApp.getInstance().setLogged(true);
                    callBack.onSuccess(response.body());
                } else {
                    Log.d("network", response.code() + "");
                    callBack.onError("");
                }
            }

            @Override
            public void onFailure(Call<AuthRs> call, Throwable t) {

            }
        });
    }

    public interface GetAuthCallBack {
        void onSuccess(AuthRs response);

        void onError(String error);
    }
}
