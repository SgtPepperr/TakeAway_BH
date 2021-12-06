package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.takeaway_bh.Bean.Address;
import com.example.takeaway_bh.MyApp;
import com.example.takeaway_bh.databinding.ActivityChangeAddressBinding;

import org.litepal.LitePal;

public class ChangeAddress extends AppCompatActivity {

    private ActivityChangeAddressBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangeAddressBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Address address = LitePal.where("userName is ?", MyApp.getUserName()).findFirst(Address.class);
        if (address != null)
            binding.oldAddress.setText(address.getAddress());


        binding.changeAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String NewAddress = binding.newParent.getText().toString();
                if (NewAddress.equals("")) {
                    Toast.makeText(ChangeAddress.this, "请输入新地址", Toast.LENGTH_LONG).show();
                } else {
                    if (address != null)
                        address.delete();
                    Address add = new Address();
                    add.setAddress(NewAddress);
                    add.setUserName(MyApp.getUserName());
                    add.save();
                    Intent intent = new Intent(ChangeAddress.this, CustomerIndex.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}