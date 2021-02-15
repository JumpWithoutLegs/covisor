package com.pavelgostudy.startandroid.covisor.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.pavelgostudy.startandroid.covisor.R;
import com.pavelgostudy.startandroid.covisor.viewmodel.AuthViewModel;

import java.util.Objects;


public class AuthFragment extends Fragment {
    private BottomNavigationView bottomNavigationView;
    private NavHostFragment navHostFragment;
    private AuthViewModel authViewModel;
    private TextInputLayout login;
    private TextInputLayout password;
    private SavedStateHandle savedStateHandle;
    private SharedPreferences sharedPreferences;
    private Toolbar toolbar;
    public static String LOGIN_SUCCESSFUL = "LOGIN_SUCCESSFUL";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_auth, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setVisibility(View.GONE);
        toolbar = requireActivity().findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        toolbar.hideOverflowMenu();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        login = view.findViewById(R.id.input_login_ti);
        password = view.findViewById(R.id.input_password_ti);
        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        savedStateHandle = Objects.requireNonNull(Navigation.findNavController(requireActivity().findViewById(R.id.nav_host_fragment))
                .getPreviousBackStackEntry())
                .getSavedStateHandle();
        savedStateHandle.set(LOGIN_SUCCESSFUL, false);
        authViewModel.getAuthLiveData().observe(getViewLifecycleOwner(), response -> {
            if (response.getSuccess()) {
                TextView t = requireActivity().findViewById(R.id.userfio_id);
                t.setText(response.getFio());
                savedStateHandle.set(LOGIN_SUCCESSFUL, true);
                sharedPreferences = requireActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("empid", response.getEmpid());
                editor.apply();
                toolbar.setVisibility(View.VISIBLE);
                NavHostFragment.findNavController(this).popBackStack();
            } else {
                Toast.makeText(getContext(), "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });

        authViewModel.getErrorLiveData().observe(getViewLifecycleOwner(), error -> Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show());
        view.findViewById(R.id.sign_in_btn).setOnClickListener(v -> authViewModel.launchAuthProcess(
                Objects.requireNonNull(login.getEditText()).getText().toString(),
                Objects.requireNonNull(password.getEditText()).getText().toString()));
    }


}