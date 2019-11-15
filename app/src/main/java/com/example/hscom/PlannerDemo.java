package com.example.hscom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlannerDemo extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DemoPlannerAdapter plannerAdapter;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planner_demo);
        recyclerView = findViewById(R.id.plannerDemoRecyclerView);
        btn = findViewById(R.id.addPlanDemoBtn);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        plannerAdapter = new DemoPlannerAdapter(getApplicationContext());
        plannerAdapter.addItem(new PlannerItemDemo("면접 기출","~11/1"));
        plannerAdapter.addItem(new PlannerItemDemo("자소서 정리","~11/1"));
        plannerAdapter.addItem(new PlannerItemDemo("국어 자습서","~11/3"));
        plannerAdapter.addItem(new PlannerItemDemo("수학 쎈","~11/4"));
        plannerAdapter.addItem(new PlannerItemDemo("수학 수행","~11/6"));
        plannerAdapter.addItem(new PlannerItemDemo("영어 올백","~11/7"));
        plannerAdapter.addItem(new PlannerItemDemo("학교 기출","~11/8"));
        plannerAdapter.addItem(new PlannerItemDemo("과학 오투","~11/9"));
        recyclerView.setAdapter(plannerAdapter);
        plannerAdapter.setOnItemClickListener(new DemoPlannerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DemoPlannerAdapter.ViewHolder holder, View view, int position) {
                //추후 수정 및 삭제 기능 추가 예정
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent
                startActivity(new Intent(PlannerDemo.this, AddPlanDemo.class));
            }
        });
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            String task = bundle.getString("Title");
            String time = bundle.getString("time");
            plannerAdapter.addItem(new PlannerItemDemo(task + "", time + ""));
        }
    }
}
