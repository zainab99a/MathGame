package com.zainabali.yz.mathgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class AdditionActivity extends AppCompatActivity {
    TextView score;
    TextView life;
    TextView time;

    TextView question;
    EditText answer;
    Button btn1, btn2;
    //this to generate many type of numbers
    Random random=new Random();
    int num1,num2;
    //container
    int userAnswer;
    int trueAnswer;
    int userScore=0;
    int userLife=3;
    //we call time class in java
    CountDownTimer timer;
    //we create long container to determine the time in ms
    //60s
    private static final long START_TIMER=20000;
    //we create a boolean value to check if timer on or off
    boolean timer_running;
    long time_left=START_TIMER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);

        score=findViewById(R.id.score);
        life=findViewById(R.id.life);
        time=findViewById(R.id.time);
        question=findViewById(R.id.question);
        answer=findViewById(R.id.answer);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        game();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//مربع الاجابه ياخذها من userAnswer و يجيكها مع الجواب الصح
                userAnswer=Integer.valueOf(answer.getText().toString());
                //when user click ok time started
                pauseTimer();

                if (trueAnswer==userAnswer){
                   userScore+=10;
                   score.setText(""+ userScore);
                   question.setText("your answer is true");
                }
                else {

                    userLife-=1;
                    life.setText(""+ userLife);
                    question.setText("your answer is wrong");


                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //we call the game() again when click next question button
              answer.setText("");

                //when user click next question time is reset
                resetTimer();

                if (userLife<=0){
                    Toast.makeText(AdditionActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(AdditionActivity.this,ResultActivity.class);
                    intent.putExtra(ResultActivity.SCORE,userScore);
                    startActivity(intent);
                    finish();

                }
                else {
                    game();
                }


            }
        });


    }
    //we create a method for question
    //we call it in onCreate() to run it first
    public void game() {
        //to generate a random number
        //boundلتحديد الارقام
        num1 = random.nextInt(100);
        num2 = random.nextInt(100);
        trueAnswer=num1+num2;
        //to show the mathematics operation in text view
        question.setText(num1 + "+" + num2);
        time();
    }
    //this method for time
    public void  time(){
        timer=new CountDownTimer(time_left,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                time_left=millisUntilFinished;
                updateText();
            }

            @Override
            public void onFinish() {

                timer_running=false;
                pauseTimer();
                resetTimer();
                updateText();
                userLife-=1;
                life.setText(""+userLife);
                question.setText("time is up!");
            }


        }.start();
        timer_running=true;
    }

    private void pauseTimer() {
        timer.cancel();
        timer_running=false;
    }

    private void updateText() {
        int second= (int) ((time_left/1000)%60);
        String time_left=String.format(Locale.getDefault(),"%02d",second);
        time.setText(time_left);
    }

    private void resetTimer() {
        time_left=START_TIMER;
        updateText();
    }
}//end of class