package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.Bean.TakeOrder;
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.databinding.ActivityPaymentBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment extends BaseActivity {

    private ActivityPaymentBinding binding;
    private String StoreName;
    private String money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        StoreName = intent.getStringExtra("StoreName");
        money = intent.getStringExtra("allmoney");

        binding.tvCost.setText(money);
        binding.businessNameAndId.setText(StoreName);
        binding.finishPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOrder();
            }
        });
    }

    void addOrder() {
        TakeOrder order = new TakeOrder();
        if (binding.paymentAddress.getText().toString().equals("") || binding.paymentPhone.getText().toString().equals("")) {
            Toast.makeText(Payment.this, "请完整填写地址和电话信息", Toast.LENGTH_SHORT).show();
        } else {
            order.setAddress(binding.paymentAddress.getText().toString());
            order.setCustomer_text(binding.paymentText.getText().toString());
            order.setTotal_price(Float.parseFloat(money.substring(1)));
            order.setReceive_phone(binding.paymentPhone.getText().toString());
            order.setName(MyApp.getUserName() + "用户  NO." + MyApp.getId() + "订单");
            order.setSales_user(StoreName);
            order.setReceive(false);
            order.setOver(false);
            order.setPunctuality(false);
            order.setCustomer_user(MyApp.getUserName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
//获取当前时间
            Date date = new Date(System.currentTimeMillis());
//        Log.d("BaseActivity",simpleDateFormat.format(date));
            order.setTakeorder_time(simpleDateFormat.format(date));
            order.save();
            Intent intent = new Intent(Payment.this, PaymentFinish.class);
            startActivity(intent);
        }
    }
}
