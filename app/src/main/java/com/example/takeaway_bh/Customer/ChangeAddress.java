package com.example.takeaway_bh.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.takeaway_bh.Customer.ui.home.HomeFragment;
import com.example.takeaway_bh.R;

public class ChangeAddress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);

        View view = findViewById(R.id.change_address_button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeAddress.this, HomeFragment.class);
                startActivity(intent);
            }
        });
    }
}