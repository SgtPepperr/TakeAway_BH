package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.R;

public class Payment extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        View view = findViewById(R.id.finish_payment);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payment.this, PaymentFinish.class);
                startActivity(intent);
            }
        });
    }
}
