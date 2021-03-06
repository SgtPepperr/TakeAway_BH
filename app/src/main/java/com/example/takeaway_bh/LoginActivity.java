package com.example.takeaway_bh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.takeaway_bh.Bean.Good;
import com.example.takeaway_bh.Bean.Store;
import com.example.takeaway_bh.Bean.User;
import com.example.takeaway_bh.Customer.CustomerIndex;
import com.example.takeaway_bh.Manage.ManageIndex;
import com.example.takeaway_bh.Rider.RiderIndex;
import com.example.takeaway_bh.databinding.ActivityLoginBinding;

import org.litepal.LitePal;

import java.util.List;


public class LoginActivity extends BaseActivity {

    private SharedPreferences pref;

    private ActivityLoginBinding binding;

    private SharedPreferences.Editor editor;

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    private CheckBox remeberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (LitePal.findAll(Store.class).size() == 0) {
            InitLitePal init = new InitLitePal();
            init.init();
        }

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        accountEdit = binding.username;
        passwordEdit = binding.password;
        remeberPass = binding.remember;
        login = binding.login;

        boolean isRemember = pref.getBoolean("remember password", false);
        if (isRemember) {
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            remeberPass.setChecked(true);
        }

        List<User> users = LitePal.findAll(User.class);
        for (User u : users) {
            Log.d("Login", "username is " + u.getUsername());
            Log.d("Login", "password is " + u.getPassword());
            Log.d("Login", "isRider is " + u.isRider());
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                List<User> users = LitePal.where("username=?", account).find(User.class);
                // 如果账号是admin且密码是123456，就认为登录成功
                if (users.size() == 0) {
                    Log.d("Login", "user is 0");
                    Toast.makeText(LoginActivity.this, "用户不存在，请先注册", Toast.LENGTH_SHORT).show();
                } else {
                    String pass = users.get(0).getPassword();
                    if (!pass.equals(password)) {
                        Log.d("Login", "password is wrong");
                        Toast.makeText(LoginActivity.this, "用户密码不正确", Toast.LENGTH_SHORT).show();
                    } else if (binding.chooseway.isChecked() != users.get(0).isRider()) {
                        Log.d("Login", "身份不匹配鸭兄弟");
                        Toast.makeText(LoginActivity.this, "身份不匹配", Toast.LENGTH_SHORT).show();
                    } else {
                        editor = pref.edit();
                        if (remeberPass.isChecked()) {
                            editor.putBoolean("remember password", true);
                            editor.putString("account", account);
                            editor.putString("password", password);
                        } else {
                            editor.clear();
                        }
                        editor.apply();
                        MyApp.setUserName(account);
                        if (binding.chooseway.isChecked()) {
                            MyApp.setIsRider(true);
                            Intent intent = new Intent(LoginActivity.this, RiderIndex.class);
                            intent.putExtra("login.username", account);
                            startActivity(intent);
                        } else {
                            MyApp.setIsRider(false);
                            Intent intent = new Intent(LoginActivity.this, CustomerIndex.class);
                            intent.putExtra("login.username", account);
                            startActivity(intent);
                        }
//                        finish();
                    }
                }
            }
        });

        binding.register.setOnClickListener(new View.OnClickListener() {         //进入注册页面
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        binding.manages.setOnClickListener(new View.OnClickListener() {      //进入管理员界面
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ManageIndex.class);
                startActivity(intent);
            }
        });


        binding.forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Store> stores = LitePal.findAll(Store.class);
                List<Good> goods = LitePal.findAll(Good.class);
                for (Store s : stores) {
                    s.delete();
                }
                for (Good g : goods) {
                    g.delete();
                }
                new InitLitePal().init();
            }
        });

    }
}
