package com.example.takeaway_bh.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.Bean.User;
import com.example.takeaway_bh.LoginActivity;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.RegisterActivity;
import com.example.takeaway_bh.databinding.ActivityStoreIndexBinding;
import com.example.takeaway_bh.databinding.FragmentIndexBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreIndex extends BaseActivity {
    private List<Good> list = new ArrayList<>();
    private ActivityStoreIndexBinding binding;
    private String StoreName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_store_index);
        Intent intent = getIntent();
        StoreName=intent.getStringExtra("StoreName");

        list = LitePal.where("StoreName=?", StoreName).find(Good.class);

        for(Good s : list){                                                //调试+初始化
//            Log.d("StoreIndex","GoodName is "+s.getName() + " StoreName is " + s.getStoreName());
            s.setImageId(R.drawable.apple_pic);
            s.save();
        }
//        list = LitePal.where("StoreName=?", StoreName).find(Good.class);

        binding = ActivityStoreIndexBinding.inflate(getLayoutInflater());
        LinearLayoutManager layoutManager=new LinearLayoutManager(StoreIndex.this);
        binding.storeListView.setLayoutManager(layoutManager);
        GoodAdapter adapter=new GoodAdapter(list);
        binding.storeListView.setAdapter(adapter);
        binding.storeImage.setImageResource(R.drawable.banana_pic);
        setContentView(binding.getRoot());

//        View view = findViewById(R.id.floatingButton);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(StoreIndex.this, Payment.class);
//                startActivity(intent);
//            }
//        });
    }
}