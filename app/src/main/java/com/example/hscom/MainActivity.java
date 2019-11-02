package com.example.hscom;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler(){
            public void handleMessage (Message msg){
                super.handleMessage(msg);
                startActivity(new Intent(MainActivity.this, hscom_list.class));
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0,2500);
    }
}
