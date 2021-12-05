package com.example.takeaway_bh.Rider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.R;

public class RiderIndex extends BaseActivity {

    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider_index);
        Intent in=getIntent();
        username=in.getStringExtra("login.username");
    }

}