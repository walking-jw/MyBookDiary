package com.teambook.mybookdiary.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.teambook.mybookdiary.R;

public class BookListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        // ActionBar 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


    }
}