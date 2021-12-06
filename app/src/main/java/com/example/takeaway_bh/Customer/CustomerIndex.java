package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityCustomerIndexBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerIndex extends BaseActivity {

    public String username;
    private ActivityCustomerIndexBinding binding;
    private Fragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent in = getIntent();
        username = in.getStringExtra("login.username");
        myFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_activity_customer_index);


        binding = ActivityCustomerIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_index, R.id.navigation_order)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_customer_index);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }

}