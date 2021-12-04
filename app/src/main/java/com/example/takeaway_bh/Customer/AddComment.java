package com.example.takeaway_bh.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.takeaway_bh.BaseActivity;
import com.example.takeaway_bh.R;

public class AddComment extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comment);

        View view = findViewById(R.id.add_comment_button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddComment.this, CustomerIndex.class);
                startActivity(intent);
            }
        });
    }
}
