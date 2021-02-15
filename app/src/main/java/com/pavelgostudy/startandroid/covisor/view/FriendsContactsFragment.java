package com.pavelgostudy.startandroid.covisor.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.adapters.ContactsRecyclerViewAdapter;
import com.pavelgostudy.startandroid.covisor.viewmodel.FriendsContactsViewModel;

import java.util.Objects;

public class FriendsContactsFragment extends Fragment {
    private RecyclerView rv;
    private ContactsRecyclerViewAdapter adapter;
    private FriendsContactsViewModel friendsContactsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView t = requireActivity().findViewById(R.id.toolbar_title);
        t.setText("Группа- Друзья");
        return inflater.inflate(R.layout.fragment_friends_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        friendsContactsViewModel = new ViewModelProvider(this).get(FriendsContactsViewModel.class);
        friendsContactsViewModel.getContactsGroupedByFriends(sharedPreferences.getString("empid", ""));
        friendsContactsViewModel.getGroupedByFriendsLiveData().observe(getViewLifecycleOwner(), contactsGroupedRs -> {
            rv = requireActivity().findViewById(R.id.friends_contacts_recycler_view);
            adapter = new ContactsRecyclerViewAdapter(Objects.requireNonNull(friendsContactsViewModel.getGroupedByFriendsLiveData().getValue()).getData());
            rv.setAdapter(adapter);
            rv.getRecycledViewPool().setMaxRecycledViews(0, 20);
            rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        });
    }
}