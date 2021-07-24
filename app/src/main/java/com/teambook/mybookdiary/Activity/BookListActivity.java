package com.teambook.mybookdiary.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.teambook.mybookdiary.BookListAdapter;
import com.teambook.mybookdiary.R;

public class BookListActivity extends AppCompatActivity {

    RecyclerView rv_booklists = null;
    RecyclerView.LayoutManager layoutManager = null;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        // ActionBar 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // recyclerView 연결
        rv_booklists = findViewById(R.id.rv_booklists);
        layoutManager = new LinearLayoutManager(BookListActivity.this);
        rv_booklists.setLayoutManager(layoutManager);

        //adapter연결
        adapter = new BookListAdapter();
        rv_booklists.setAdapter(adapter);

        //ip와, data 부르기
//        Intent intent = getIntent();
//        myIP = intent.getStringExtra("myIP");
//        urlAddr = "http://"+ myIP + ":8080/test/diarySelectList.jsp?";
//        Log.v("Message","listActivity_urlAddr"+urlAddr);


    }
}