package com.example.hscom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class hscom_list extends AppCompatActivity {
    Button intentBtn1,intentBtn2,refreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hscom_list);
        intentBtn1 = findViewById(R.id.intentBtn1);
        intentBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hscom_list.this,Schoolinfo.class);
                startActivity(intent);
            }
        });
        intentBtn2 = findViewById(R.id.intentBtn2);
        intentBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hscom_list.this,CreateSchool.class);
                startActivity(intent);
            }
        });
        refreshBtn = findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ListView에 학교 나열 및 드롭다운 창에 분류 눌렀을 때 구현?
            }
        });

    }
}
