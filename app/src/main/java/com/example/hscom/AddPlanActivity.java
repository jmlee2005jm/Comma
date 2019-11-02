package com.example.hscom;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);

        final EditText mainText = (EditText)findViewById(R.id.mainText);
        final EditText subText = (EditText)findViewById(R.id.subText);

/*        Intent intent = getIntent();
        mainText.setText(intent.getStringExtra("main"));*/

        Button btnX = (Button)findViewById(R.id.btnX);
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button btnO = findViewById(R.id.btnO);
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =  new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("mainText",mainText.getText().toString());
                intent.putExtra("subText",subText.getText().toString());
                intent.putExtra("btn",1);
                setResult(3000, intent);
                finish();
            }
        });
    }
}