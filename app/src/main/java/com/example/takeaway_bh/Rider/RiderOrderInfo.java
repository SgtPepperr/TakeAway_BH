package com.example.takeaway_bh.Rider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.databinding.ActivityRiderOrderInfoBinding;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RiderOrderInfo extends AppCompatActivity {
    private ActivityRiderOrderInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiderOrderInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String id = getIntent().getStringExtra("OrderId");
        TakeOrder order = LitePal.where("name is ?", id).find(TakeOrder.class).get(0);

        binding.businessNameAndId.setText(order.getSales_user());
        binding.tvCost.setText("￥" + order.getTotal_price());
        binding.paymentAddress.setText(order.getAddress());
        binding.paymentPhone.setText(order.getReceive_phone());
        binding.paymentText.setText(order.getCustomer_text());
        if (order.isOver()) {
            binding.orderInformStatement.setText("订单状态：已完成");
            binding.takeOrder.setVisibility(View.GONE);
        } else if (order.isReceive()) {
            binding.orderInformStatement.setText("订单状态：已接单");
            binding.takeOrder.setVisibility(View.VISIBLE);
            binding.takeOrder.setText("完成订单");
        } else {
            binding.orderInformStatement.setText("订单状态：未接单");
            binding.takeOrder.setVisibility(View.VISIBLE);
            binding.takeOrder.setText("接单");
        }

        binding.takeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!order.isReceive()) {
                    order.setRider_user(MyApp.getUserName());
                    order.setReceive(true);
                    order.save();
                } else {
                    order.setOver(true);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
//获取当前时间
                    Date date = new Date(System.currentTimeMillis());
//        Log.d("BaseActivity",simpleDateFormat.format(date));
                    order.setArrival_time(simpleDateFormat.format(date));
                    order.save();
                }
                Intent intent = new Intent(RiderOrderInfo.this, RiderIndex.class);
                startActivity(intent);
                finish();
            }
        });
    }
}