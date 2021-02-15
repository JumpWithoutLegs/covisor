package com.pavelgostudy.startandroid.covisor.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.model.auth.AuthRs;
import com.pavelgostudy.startandroid.covisor.repository.AuthRepository;

public class AuthViewModel extends ViewModel {
    private MutableLiveData<AuthRs> authLiveData = new MutableLiveData<>();
    private MutableLiveData<String> errorLiveData = new MutableLiveData<>();
    private AuthRepository authRepository = MyApp.getInstance().authRepository;

    public void launchAuthProcess(String login, String password) {

        authRepository.getUserData(login, password, new AuthRepository.GetAuthCallBack() {
            @Override
            public void onSuccess(AuthRs response) {
                authLiveData.setValue(response);
            }

            @Override
            public void onError(String error) {
                errorLiveData.setValue(error);
            }
        });
    }

    public MutableLiveData<AuthRs> getAuthLiveData() {
        return authLiveData;
    }

    public MutableLiveData<String> getErrorLiveData() {
        return errorLiveData;
    }
}
