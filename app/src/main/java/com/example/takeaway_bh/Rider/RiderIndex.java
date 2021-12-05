package com.example.takeaway_bh.Rider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.Customer.OrderAdapter;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityRiderIndexBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class RiderIndex extends BaseActivity {
    private ActivityRiderIndexBinding binding;
    private List<TakeOrder> orderList=new ArrayList<>();
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRiderIndexBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent in=getIntent();
        username=in.getStringExtra("login.username");

        orderList= LitePal.where("receive is ?","0").find(TakeOrder.class);
//        for(TakeOrder order:orderList){
//            order.delete();
//        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerRiderIndex.setLayoutManager(layoutManager);
        OrderAdapter adapter=new OrderAdapter(orderList);
        binding.recyclerRiderIndex.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rider_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.my_order:
                Intent intent=new Intent(RiderIndex.this,RiderOrder.class);
                startActivity(intent);
                break;
            case R.id.my_info:
            default:
        }
        return true;
    }
}