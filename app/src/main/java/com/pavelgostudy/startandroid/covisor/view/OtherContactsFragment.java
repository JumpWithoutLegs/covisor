package com.pavelgostudy.startandroid.covisor.view;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.adapters.ContactsRecyclerViewAdapter;
import com.pavelgostudy.startandroid.covisor.viewmodel.FriendsContactsViewModel;
import com.pavelgostudy.startandroid.covisor.viewmodel.OtherContactsViewModel;

import java.util.Objects;

public class OtherContactsFragment extends Fragment {

    private RecyclerView rv;
    private ContactsRecyclerViewAdapter adapter;
    private OtherContactsViewModel otherContactsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView t = requireActivity().findViewById(R.id.toolbar_title);
        t.setText("Группа- Другие");
        return inflater.inflate(R.layout.fragment_other_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        otherContactsViewModel = new ViewModelProvider(this).get(OtherContactsViewModel.class);
        otherContactsViewModel.getContactsGroupedByOther(sharedPreferences.getString("empid", ""));
        otherContactsViewModel.getGroupedByOtherLiveData().observe(getViewLifecycleOwner(), contactsGroupedRs -> {
            rv = requireActivity().findViewById(R.id.other_contacts_recycler_view);
            adapter = new ContactsRecyclerViewAdapter(Objects.requireNonNull(otherContactsViewModel.getGroupedByOtherLiveData().getValue()).getData());
            rv.setAdapter(adapter);
            rv.getRecycledViewPool().setMaxRecycledViews(0, 20);
            rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        });
    }
}