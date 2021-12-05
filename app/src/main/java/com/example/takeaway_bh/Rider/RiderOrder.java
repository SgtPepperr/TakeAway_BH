package com.example.takeaway_bh.Rider;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.Customer.OrderAdapter;
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.R;
import com.example.takeaway_bh.databinding.ActivityRiderOrderBinding;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class RiderOrder extends BaseActivity {
    private ActivityRiderOrderBinding binding;
    private List<TakeOrder> orderList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRiderOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        orderList= LitePal.where("rider_user is ?", MyApp.getUserName()).find(TakeOrder.class);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerRiderOrder.setLayoutManager(layoutManager);
        OrderAdapter adapter=new OrderAdapter(orderList);
        binding.recyclerRiderOrder.setAdapter(adapter);
    }
}