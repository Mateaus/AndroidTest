package com.example.hiltsandbox.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hiltsandbox.R;
import com.example.hiltsandbox.databinding.ActivityMainBinding;
import com.example.hiltsandbox.fragments.todo.ToDoViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public final class MainActivity extends AppCompatActivity {

    private NavHostFragment navHostFragment;

    private NavController navController;

    private ActivityMainBinding viewBinding;

    private ToDoViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initUI();
    }

    private void initUI() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mainActivityFragmentContainerView);

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();
        }
    }
}