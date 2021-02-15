package com.pavelgostudy.startandroid.covisor.view;

import android.app.Application;
import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pavelgostudy.startandroid.covisor.MyApp;
import com.pavelgostudy.startandroid.covisor.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setItemIconTintList(null);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, Objects.requireNonNull(navHostFragment).getNavController());
    }
}