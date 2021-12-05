package com.example.takeaway_bh.Manage;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.databinding.ActivityCheckGoodBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class CheckGoodActivity extends BaseActivity {
    private List<Good> list = new ArrayList<>();
    private ActivityCheckGoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_home);
        Intent intent = getIntent();

        list = LitePal.where("StoreName=?", intent.getStringExtra("StoreName")).find(Good.class);

        binding = ActivityCheckGoodBinding.inflate(getLayoutInflater());
        LinearLayoutManager layoutManager=new LinearLayoutManager(CheckGoodActivity.this);
        binding.recyclerCheckGood.setLayoutManager(layoutManager);
        CheckGoodAdapter adapter=new CheckGoodAdapter(list);
        binding.recyclerCheckGood.setAdapter(adapter);
        setContentView(binding.getRoot());

    }

}
