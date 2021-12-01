package com.example.takeaway_bh.Manage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityAddGoodBinding;

import org.litepal.LitePal;

import java.util.List;

public class AddGood extends AppCompatActivity {

    private ActivityAddGoodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddGoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String storename=binding.storename.getText().toString();
                String goodname=binding.goodname.getText().toString();
                float price=binding.price.getAlpha();

                List<Good> goods= LitePal.where("StoreName = ? and name = ?",storename,goodname).find(Good.class);
                if(goods.size()!=0){
                    Toast.makeText(AddGood.this,"该商品已存在,请修改信息",Toast.LENGTH_SHORT).show();
                }else{
                    Good good=new Good();
                    good.setStoreName(storename);
                    good.setName(goodname);
                    good.setPrice(price);
                    good.save();

                    List<Store> stores=LitePal.where("StoreName = ?",storename).find(Store.class);
                    if(stores.size()==0){
                        Store store=new Store();
                        store.setStoreName(storename);
                        store.save();
                    }
                    finish();
                }
            }
        });
    }
}