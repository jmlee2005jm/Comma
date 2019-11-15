package com.example.hscom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlanDemo extends AppCompatActivity {
    private EditText titleInput, specificInput, timeInput;
    private Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan_demo);
        titleInput = findViewById(R.id.addPlanDemoTitle);
        specificInput = findViewById(R.id.addPlanDemoSpecific);
        timeInput = findViewById(R.id.addPlanDemoTime);
        confirmBtn = findViewById(R.id.addPlanConfirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, specific, time;
                title = titleInput.getText().toString();
                specific = specificInput.getText().toString();
                time = timeInput.getText().toString();
                Intent i = new Intent(AddPlanDemo.this, PlannerDemo.class);
                i.putExtra("Title",title);
                i.putExtra("time",time);
                startActivity(i);
            }
        });
    }
}
