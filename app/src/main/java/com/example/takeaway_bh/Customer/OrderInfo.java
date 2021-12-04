package com.example.takeaway_bh.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.R;

import org.litepal.LitePal;

public class OrderInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_information);
        String id=getIntent().getStringExtra("OrderId");
        TakeOrder order= LitePal.where("name is ?",id).find(TakeOrder.class).get(0);
        TextView storename=findViewById(R.id.info_business_nameAndId);
        TextView money=findViewById(R.id.info_tv_cost);
        TextView state=findViewById(R.id.order_inform_statement);
        TextView address=findViewById(R.id.info_payment_address);
        TextView phone=findViewById(R.id.info_payment_phone);
        TextView text=findViewById(R.id.info_payment_text);
        TextView take_order_time=findViewById(R.id.info_take_order_time);

        storename.setText(order.getSales_user());
        money.setText("￥"+order.getTotal_price());
        address.setText(order.getAddress());
        phone.setText(order.getReceive_phone());
        text.setText(order.getCustomer_text());
        Log.d("OrderInfo",order.getTakeorder_time());
        take_order_time.setText(order.getTakeorder_time());
        if(order.isOver()){
            state.setText("订单状态：已完成");
        }else if(order.isReceive()){
            state.setText("订单状态：已接单");
        }else{
            state.setText("订单状态：已下单");
        }
    }
}