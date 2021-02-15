package com.pavelgostudy.startandroid.covisor.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.viewmodel.ContactsViewModel;

public class ContactsFragment extends Fragment {
    NavHostFragment navHostFragment;
    ContactsViewModel contactsViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView t = getActivity().findViewById(R.id.toolbar_title);
        t.setText("Группы контактов");
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactsViewModel = new ViewModelProvider(this).get(ContactsViewModel.class);

        view.findViewById(R.id.family_group_linear_id).setOnClickListener(s -> {
            Navigation.findNavController(requireActivity().findViewById(R.id.nav_host_fragment)).navigate(R.id.action_contactsFragment_to_familyContactsFragment);
        });
        view.findViewById(R.id.family_group_linear_id).setOnClickListener(s -> {
            Navigation.findNavController(requireActivity().findViewById(R.id.nav_host_fragment)).navigate(R.id.action_contactsFragment_to_familyContactsFragment);
        });
        view.findViewById(R.id.family_group_linear_id).setOnClickListener(s -> {
            Navigation.findNavController(requireActivity().findViewById(R.id.nav_host_fragment)).navigate(R.id.action_contactsFragment_to_familyContactsFragment);
        });
        view.findViewById(R.id.family_group_linear_id).setOnClickListener(s -> {
            Navigation.findNavController(requireActivity().findViewById(R.id.nav_host_fragment)).navigate(R.id.action_contactsFragment_to_familyContactsFragment);
        });
    }
}