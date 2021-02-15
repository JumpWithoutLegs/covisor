package com.pavelgostudy.startandroid.covisor.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.viewmodel.WorkContactsViewModel;

public class WorkContactsFragment extends Fragment {

    private WorkContactsViewModel mViewModel;

    public static WorkContactsFragment newInstance() {
        return new WorkContactsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_work_contacts, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(WorkContactsViewModel.class);
        // TODO: Use the ViewModel
    }

}