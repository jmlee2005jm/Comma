package com.example.hscom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class myeongdukComDemo extends AppCompatActivity {
    private TextView textViewTitle, textViewArticle;
    private EditText editTextTitle,editTextArticle;
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myeongduk_com_demo);
        textViewArticle = findViewById(R.id.textViewDemo);
        textViewTitle = findViewById(R.id.textViewTitleDemo);
        editTextTitle = findViewById(R.id.myeongdukArticleTitleInput);
        editTextArticle = findViewById(R.id.myeongdukArticleInput);
        button1 = findViewById(R.id.myeongdukArticleDemoBtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTextTitle.getText().toString();
                String article = editTextArticle.getText().toString();
                textViewArticle.setText(article);
                textViewTitle.setText(title);
            }
        });
    }
}
