package com.pavelgostudy.startandroid.covisor.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRs;
import com.pavelgostudy.startandroid.covisor.repository.GroupedContactsRepository;

public class FamilyContractsViewModel extends ViewModel {
    private MutableLiveData<ContactsGroupedRs> groupedByFamilyLiveData = new MutableLiveData<>();
    private GroupedContactsRepository contactsRepository = MyApp.getInstance().groupedContactsRepository;

    public void getContactsGroupedByFamily(String empid) {
        contactsRepository.getContactsGroupedByOrder(2, empid,
                new GroupedContactsRepository.GetGroupedContactsCallBack() {
                    @Override
                    public void onSuccess(ContactsGroupedRs response) {
                        groupedByFamilyLiveData.setValue(response);
                    }

                    @Override
                    public void onError(String error) {

                    }
                });
    }

    public MutableLiveData<ContactsGroupedRs> getGroupedByFamilyLiveData() {
        return groupedByFamilyLiveData;
    }

}
