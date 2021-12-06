package com.example.takeaway_bh.Manage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityAddGoodBinding;

import org.litepal.LitePal;

import java.util.List;

public class AddGoodActivity extends AppCompatActivity {

    private ActivityAddGoodBinding binding;
    private String storeName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddGoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String storename = binding.storename.getText().toString();
                String goodname = binding.goodname.getText().toString();
                String price = binding.price.getText().toString();

                List<Good> goods = LitePal.where("StoreName = ? and name = ?", storename, goodname).find(Good.class);
                if (goods.size() != 0) {
                    Toast.makeText(AddGoodActivity.this, "该商品已存在,请修改信息", Toast.LENGTH_SHORT).show();
                } else if (goodname.equals("")) {
                    Toast.makeText(AddGoodActivity.this, "请填写菜品信息", Toast.LENGTH_SHORT).show();
                } else if (price.equals("")) {
                    Toast.makeText(AddGoodActivity.this, "请填写价格信息", Toast.LENGTH_SHORT).show();
                } else {
                    Good good = new Good();
                    good.setStoreName(storename);
                    good.setName(goodname);
                    good.setPrice(Float.valueOf(price));
                    good.setImageId(R.drawable.gan_guo_tu);
                    good.save();

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