package com.example.hscom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

public class CreateSchool extends AppCompatActivity {
    private Button button;
    private EditText schoolName, schoolClass, schoolWeb;
    private String Name, Class, Website;
    private int id;
    private DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_school);
        button = findViewById(R.id.confirmBtn);
        schoolName = findViewById(R.id.schoolNameEdit);
        schoolClass = findViewById(R.id.schoolClassEdit);
        schoolWeb = findViewById(R.id.schoolWebsiteEdit);
        id = 0;

        myRef = FirebaseDatabase.getInstance().getReference("schools");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name = schoolName.getText().toString();
                Class = schoolClass.getText().toString();
                Website = schoolWeb.getText().toString();
                Log.e("dfdf",Name+"/"+Class+"/"+Website);
                final Info_school schoolData = new Info_school(Name, Class, Website);
                Log.e("schoolDATA" , schoolData.getSchoolName());
                myRef.runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        mutableData.child(id+"").setValue(schoolData);

                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                        Toast.makeText(CreateSchool.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });
                myRef.runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        mutableData.child("id").setValue(id);

                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                        Toast.makeText(CreateSchool.this,id+"",Toast.LENGTH_LONG).show();
                        Log.e("id",id+"");
                    }
                });
                id++;
            }
        });
    }
}
