package com.example.task_1_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;


public class EmailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

    }


    public void btnMainClick (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    public void btnLikeClick (View view) {
        Intent intent = new Intent(this, LikeActivity.class);
        startActivity(intent);
        finish();
    }
}