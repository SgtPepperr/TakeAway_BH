package com.example.takeaway_bh.Manage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityManageIndexBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class ManageIndex extends BaseActivity {

    private ActivityManageIndexBinding binding;
    private String storename = "";
    private StoreAdapterForManager adapter;
    private List<Store> storeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_index);

        binding = ActivityManageIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageIndex.this, AddStoreActivity.class);
                startActivity(intent);
            }
        });

        getAlStore();
    }


    private void getAlStore() {
        List<Store> stores = LitePal.findAll(Store.class);
        storeList.clear();
        storeList.addAll(stores);
        if (storeList.size() != 0) {
            runOnUiThread(new Runnable() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void run() {
                    if (null == adapter) {
                        initList(storeList);
                    } else {
                        adapter.notifyDataSetChanged();
                    }

                }
            });

        }
    }

    private void initList(List<Store> storeList) {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.rlvStore.setLayoutManager(manager);

        adapter = new StoreAdapterForManager(storeList, this);
        binding.rlvStore.setAdapter(adapter);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getAlStore();
    }
}