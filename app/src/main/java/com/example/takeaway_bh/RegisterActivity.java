package com.example.takeaway_bh;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.takeaway_bh.Bean.User;
import com.example.takeaway_bh.databinding.ActivityRegisterBinding;

import org.litepal.LitePal;

import java.util.List;

public class RegisterActivity extends BaseActivity {

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<User> users = LitePal.findAll(User.class);
        for (User u : users) {
            Log.d("Register", "username is " + u.getUsername());
            Log.d("Register", "password is " + u.getPassword());
            Log.d("Register", "isRider is " + u.isRider());
        }

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();
                String password2 = binding.password2.getText().toString();
                boolean isRider = binding.chooseway.isChecked();
                if(username.equals("")||password.equals("")||password2.equals("")){
                    Toast.makeText(RegisterActivity.this, "请完整填写信息", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(password2)) {
                    Toast.makeText(RegisterActivity.this, "两次输入密码不一致，请重新输入", Toast.LENGTH_SHORT).show();
                } else {
                    List<User> users = LitePal.where("username=?", username).find(User.class);
                    if (users.size() == 0) {
                        User user = new User();
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setRider(isRider);
                        user.save();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "用户名已存在，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}