package com.pavelgostudy.startandroid.covisor.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.pavelgostudy.startandroid.covisor.model.spisconts.ContactsGroupedRs;

public class FamilyContractsViewModel extends ViewModel {
    private MutableLiveData<ContactsGroupedRs> groupedByFamilyLiveData = new MutableLiveData<>();



    public MutableLiveData<ContactsGroupedRs> getGroupedByFamilyLiveData() {
        return groupedByFamilyLiveData;
    }

}
