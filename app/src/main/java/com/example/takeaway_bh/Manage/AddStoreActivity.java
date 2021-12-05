package com.example.takeaway_bh.Manage;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.databinding.ActivityAddStroeBinding;

import org.litepal.LitePal;

import java.util.List;

public class AddStoreActivity extends AppCompatActivity {

    private ActivityAddStroeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddStroeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
    }


    private void initView() {
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addShop();
            }
        });


    }


    /**
     * 添加商店
     */
    private void addShop() {
        String storeName = binding.tvStoreName.getText().toString();
        String storeIntroduction = binding.tvIntroduction.getText().toString();

        List<Store> stores = LitePal.where("StoreName = ?", storeName).find(Store.class);
        if (stores.size() == 0) {
            Store store = new Store();
            store.setStoreName(storeName);
            store.setIntroduction(storeIntroduction);
            store.save();
            Toast.makeText(AddStoreActivity.this, "该商店已添加", Toast.LENGTH_SHORT).show();
        } else {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(AddStoreActivity.this, "该商店已添加", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}