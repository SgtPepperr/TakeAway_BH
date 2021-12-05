package com.example.takeaway_bh.Manage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.databinding.ActivityDeleteGoodBinding;

import org.litepal.LitePal;

import java.util.List;

public class DeleteGoodActivity extends AppCompatActivity {

    private ActivityDeleteGoodBinding binding;
    private String storeName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeleteGoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String storename = binding.storename.getText().toString();
                String goodname = binding.goodname.getText().toString();

                List<Good> goods = LitePal.where("StoreName = ? and name = ?", storename, goodname).find(Good.class);
                if (goods.size() == 0) {
                    Toast.makeText(DeleteGoodActivity.this, "该商品不存在,请修改信息", Toast.LENGTH_SHORT).show();
                } else {
                    LitePal.deleteAll(Good.class,"StoreName = ? and name = ?", storename, goodname);
                    finish();
                }
            }
        });

        getIntentData();
    }


    /**
     * 获取 传输数据
     */
    private void getIntentData() {
        Intent data = getIntent();
        if (null == data) {
            return;
        }
        storeName = data.getStringExtra("store_name");
        binding.storename.setText(storeName);

    }
}