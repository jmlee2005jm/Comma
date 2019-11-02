package com.example.hscom;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Schoolinfo extends AppCompatActivity {
    Button comBtn, webBtn;
    TextView textThing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolinfo);
        comBtn = findViewById(R.id.comBtn);
        webBtn = findViewById(R.id.websiteBtn);
        textThing = findViewById(R.id.websiteBtn);
        comBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schoolinfo.this,mainHSCom.class);
                startActivity(intent);
            }
        });
        final String url = textThing.getText().toString();
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            }
        });
        //학교 정보 추가한 것도 표시
    }
}
