package com.pavelgostudy.startandroid.covisor.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRs;
import com.pavelgostudy.startandroid.covisor.repository.GroupedContactsRepository;

public class WorkContactsViewModel extends ViewModel {
    private MutableLiveData<ContactsGroupedRs> groupedByWorkLiveData = new MutableLiveData<>();
    private GroupedContactsRepository contactsRepository = MyApp.getInstance().groupedContactsRepository;

    public void getContactsGroupedByWork(String empid) {
        contactsRepository.getContactsGroupedByOrder(1, empid,
                new GroupedContactsRepository.GetGroupedContactsCallBack() {
                    @Override
                    public void onSuccess(ContactsGroupedRs response) {
                        groupedByWorkLiveData.setValue(response);
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
    }

    public MutableLiveData<ContactsGroupedRs> getGroupedByWorkLiveData() {
        return groupedByWorkLiveData;
    }
}