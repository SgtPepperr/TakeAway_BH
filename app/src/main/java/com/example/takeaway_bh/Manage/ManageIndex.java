package com.example.takeaway_bh.Manage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityMainBinding;
import com.example.takeaway_bh.databinding.ActivityManageIndexBinding;

public class ManageIndex extends BaseActivity {

    private ActivityManageIndexBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_index);

        binding=ActivityManageIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ManageIndex.this,AddGood.class);
                startActivity(intent);
            }
        });
    }
}