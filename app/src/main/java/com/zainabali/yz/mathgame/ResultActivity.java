package com.zainabali.yz.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
Button back, exist;
TextView result;
int score;
//to much with the previous activity
public static final String SCORE="score";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=findViewById(R.id.result);
        back=findViewById(R.id.back);
        exist=findViewById(R.id.exist);

        Intent intent=getIntent();
       score=intent.getIntExtra(SCORE,0);
        result.setText("Your Score :"+ score);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent i=new Intent(ResultActivity.this,MainActivity.class)  ;
              startActivity(i);
              //we close older activity when new activity open
              finish();
            }
        });
        exist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}