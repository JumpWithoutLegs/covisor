package com.pavelgostudy.startandroid.covisor.repository;

import com.pavelgostudy.startandroid.covisor.api.ApiService;
import com.pavelgostudy.startandroid.covisor.model.auth.AuthRs;

public class GroupedContactsRepository {
    private ApiService apiService;

    public GroupedContactsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getContactsGroupedByOrder(int order, GetGroupedContactsCallBack callBack) {


    }


    public interface GetGroupedContactsCallBack {
        void onSuccess(AuthRs response);

        void onError(String error);
    }


}
