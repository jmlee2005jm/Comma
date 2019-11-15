package com.example.hscom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class demoMain extends AppCompatActivity {
    Button demoPlannerBtn, demoSchoolSelectBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_main);
        demoPlannerBtn = findViewById(R.id.plannerDemoBtn);
        demoSchoolSelectBtn = findViewById(R.id.schoolSelectDemoBtn);
        demoPlannerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demoMain.this,PlannerDemo.class);
                startActivity(intent);
            }
        });
        demoSchoolSelectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(demoMain.this,demo_schoolselect.class);
                startActivity(intent);
            }
        });
    }
}
