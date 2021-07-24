package com.teambook.mybookdiary.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.teambook.mybookdiary.R;

public class MainActivity extends AppCompatActivity {

    Button btn_ToAdd, btn_ToDetail, btn_ToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btn_ToAdd = findViewById(R.id.btn_ToAddActivity);
        btn_ToDetail = findViewById(R.id.btn_ToDetailActivity);
        btn_ToList = findViewById(R.id.btn_ToListActivity);

        btn_ToAdd.setOnClickListener(onClickListener);
        btn_ToDetail.setOnClickListener(onClickListener);
        btn_ToList.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_ToAddActivity:
                    Intent intentToAdd = new Intent(MainActivity.this, BookAddActivity.class);
                    startActivity(intentToAdd);
                    break;
                case R.id.btn_ToDetailActivity:
                    Intent intentToDetail = new Intent(MainActivity.this, BookDetailActivity.class);
                    startActivity(intentToDetail);
                    break;
                case R.id.btn_ToListActivity:
                    Intent intentToList = new Intent(MainActivity.this, BookListActivity.class);
                    startActivity(intentToList);
                    break;
            }
        }
    };




}