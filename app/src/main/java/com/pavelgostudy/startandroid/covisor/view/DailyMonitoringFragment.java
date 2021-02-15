package com.pavelgostudy.startandroid.covisor.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.R;

import java.util.Objects;

public class DailyMonitoringFragment extends Fragment {
    BottomNavigationView bottomNavigationView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation_view);
        if (MyApp.getInstance().isLogged()) {
            bottomNavigationView.setVisibility(View.VISIBLE);
            TextView t = getActivity().findViewById(R.id.toolbar_title);
            t.setText("Ежедневный мониторинг");
        } else {
            NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
            Objects.requireNonNull(navHostFragment).getNavController().navigate(R.id.authFragment);
        }
        return inflater.inflate(R.layout.fragment_daily_monitoring, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}