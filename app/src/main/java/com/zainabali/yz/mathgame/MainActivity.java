package com.zainabali.yz.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button add_btn,sub_btn,mul_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_btn=findViewById(R.id.add);
        sub_btn=findViewById(R.id.sub);
        mul_btn=findViewById(R.id.multiply);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,AdditionActivity.class);
                startActivity(i);
                finish();
            }
        });
        sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SubActivity.class);
                startActivity(i);
                finish();
            }
        });
        mul_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,MulActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}