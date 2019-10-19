package com.example.hscom;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PlannerActivity extends Activity {

    List<String> data;
    ArrayAdapter<String> adapter;
    ListView list;
    TextView mainText, subText;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intentdata) {
        super.onActivityResult(requestCode, resultCode, intentdata);
        Intent intent = intentdata;
        String mainText = intent.getStringExtra("mainText");
        String subText = intent.getStringExtra("subText");
        String item = mainText+" \n"+subText;
        data.add(item.trim());
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        mainText = findViewById(R.id.mainText);
        subText = findViewById(R.id.subText);

        data = new ArrayList<String>();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data);
        list = (ListView) findViewById(R.id.list);
        Log.e("Adapter 전", "Is it");
        list.setAdapter(adapter);
        Log.e("Adapter 후", "Working?");
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), AddPlanActivity.class);
                String main =data.get(position);
                intent.putExtra("main",data.get(position));
                intent.putExtra("sub",data.get(position));
                startActivityForResult(intent, 2000);

            }
        });


        Button add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), AddPlanActivity.class);
                startActivityForResult(intent, 3000);//액티비티 띄우기
            }
        });


        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SparseBooleanArray array = list.getCheckedItemPositions();
                for (int i = 0; i < array.size(); i++) {
                    for (int j = 0; j < data.size(); j++) {
                        if (array.get(j)) {
                            data.remove(j);
                            break;
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                list.clearChoices();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}