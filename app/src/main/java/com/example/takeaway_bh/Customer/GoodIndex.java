package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.databinding.ActivityGoodIndexBinding;

import org.litepal.LitePal;

public class GoodIndex extends BaseActivity {

    private ActivityGoodIndexBinding binding;
    private String GoodName;
    private String StoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGoodIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        GoodName = getIntent().getStringExtra("Name");
        StoreName = getIntent().getStringExtra("StoreName");

        Good good = LitePal.where("Name is ? and StoreName is ?", GoodName, StoreName).findFirst(Good.class);

        binding.foodsImageView.setImageResource(good.getImageId());
        binding.foodsIngredientsText.setText(good.getName());
        binding.foodsDescriptionText.setText(good.getIntroduction());

        binding.commentFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GoodIndex.this, AddComment.class);
                startActivity(intent);
            }
        });
    }
}