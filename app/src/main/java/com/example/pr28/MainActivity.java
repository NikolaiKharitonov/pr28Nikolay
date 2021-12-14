package com.example.pr28;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnLeft;
    Button btnRight;
    Button btnScroll;

    float x1, x2, y1, y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        btnScroll = findViewById(R.id.btnScroll);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnScroll.setOnClickListener(this);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick (View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnLeft:
                intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case R.id.btnRight:
                intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
                break;
            case R.id.btnScroll:
                intent = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent);
                break;
        }
    }


    public boolean onTouchEvent(MotionEvent touchevent){
        switch(touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if(x1 < x2){
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
                if(x1 > x2) {
                    Intent k = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(k);
                }


                break;
        }
        return false;



    }

}