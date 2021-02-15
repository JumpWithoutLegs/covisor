package com.pavelgostudy.startandroid.covisor.repository;

import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.Navigation;

import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.api.ApiService;
import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRq;
import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRs;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupedContactsRepository {
    private ApiService apiService;
    private SavedStateHandle savedStateHandle;


    public GroupedContactsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getContactsGroupedByOrder(int order, String empid, GetGroupedContactsCallBack callBack) {
        ContactsGroupedRq rq = new ContactsGroupedRq();
        rq.setEmpid(empid);
        rq.setGroup(order);
        apiService.getGroupedContacts(rq).enqueue(new Callback<ContactsGroupedRs>() {
            @Override
            public void onResponse(Call<ContactsGroupedRs> call, Response<ContactsGroupedRs> response) {
                if (response.isSuccessful()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onError("error code " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ContactsGroupedRs> call, Throwable t) {

            }
        });
    }


    public interface GetGroupedContactsCallBack {
        void onSuccess(ContactsGroupedRs response);

        void onError(String error);
    }


}
