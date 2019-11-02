package com.example.hscom;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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

public class newArticle extends AppCompatActivity {
    private DatabaseReference myRef;
    private EditText articleEdit;
    private String article;
    private Button newArticleConfirmBtn;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_article);
        myRef = FirebaseDatabase.getInstance().getReference("articles");
        articleEdit = findViewById(R.id.articleEdit);
        newArticleConfirmBtn = findViewById(R.id.articleEditConfirmBtn);

        newArticleConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                article = articleEdit.getText().toString();
                myRef.runTransaction(new Transaction.Handler() {
                    @NonNull
                    @Override
                    public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                        mutableData.child(id+"").setValue(article);
                        return Transaction.success(mutableData);
                    }

                    @Override
                    public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                        Toast.makeText(newArticle.this,"Success",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        id++;
    }
}
