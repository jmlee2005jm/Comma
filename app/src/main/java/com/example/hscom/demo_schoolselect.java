package com.example.hscom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class demo_schoolselect extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_schoolselect);
        recyclerView = findViewById(R.id.comNameRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyAdapter(getApplicationContext());
        mAdapter.addItem(new MyItem("대원외고"));
        mAdapter.addItem(new MyItem("명덕외고"));
        mAdapter.addItem(new MyItem("이화외고"));
        mAdapter.addItem(new MyItem("서울외고"));
        mAdapter.addItem(new MyItem("대일외고"));
        mAdapter.addItem(new MyItem("한영외고"));
        mAdapter.addItem(new MyItem("대전외고"));
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(MyAdapter.ViewHolder holder, View view, int position) {
                MyItem item = mAdapter.getItem(position);
                Toast.makeText(getApplicationContext(), item.getName() + "가 선택되었습니다.", Toast.LENGTH_LONG).show();
                switch(position){
                    case 0:
                        startActivity(new Intent(demo_schoolselect.this, myeongdukInfoDemo.class));
                        break;

                    case 1:
                        break;

                    default:
                        break;
                }
            }
        });
    }
}
