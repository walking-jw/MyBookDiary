package com.teambook.mybookdiary.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.teambook.mybookdiary.Common.BookInfo;
import com.teambook.mybookdiary.R;

public class MainActivity extends AppCompatActivity {

    // Property
    Button btn_ToAdd, btn_ToDetail, btn_ToList;
    ImageView imageMySprout;
    TextView textView;
    FloatingActionButton floatingbtn;

    // For SQLite
    BookInfo bookInfo;
    SQLiteDatabase DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ActionBar 숨기기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // SQLite
        bookInfo = new BookInfo(MainActivity.this);

        // xml & Activity 연결해주기
        btn_ToAdd = findViewById(R.id.btn_ToAddActivity);
        btn_ToDetail = findViewById(R.id.btn_ToDetailActivity);
        btn_ToList = findViewById(R.id.btn_ToListActivity);
        imageMySprout = findViewById(R.id.imageMySprout);
        floatingbtn = findViewById(R.id.fbtn_new);
        textView = findViewById(R.id.tv_count);

        //
        btn_ToAdd.setOnClickListener(onClickListener);
        btn_ToDetail.setOnClickListener(onClickListener);
        btn_ToList.setOnClickListener(onClickListener);
        floatingbtn.setOnClickListener(onFloatingClickListener);


    }

    @Override
    protected void onResume() {
        super.onResume();
        countMyBook();
        imageSetting();
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

    View.OnClickListener onFloatingClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addMyBook();
            Intent intentToAddFloat = new Intent(MainActivity.this, BookAddActivity.class);
            startActivity(intentToAddFloat);
        }
    };

    public void addMyBook(){
        try {
            // 권한 부여
            DB = bookInfo.getWritableDatabase();

            // Query
            String query = "INSERT INTO mybook(bookname) VALUES ('책입니다.');";
            DB.execSQL(query);

            // DB 연결 끊기
            bookInfo.close();
            Toast.makeText(MainActivity.this, "INSERT OK!", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Insert Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public int countMyBook() {
        int countResult = 0;
        try {
            // 권한 부여.
            DB = bookInfo.getReadableDatabase();

            // Query
            String query = "SELECT count(*) FROM mybook;";
            Cursor cursor =  DB.rawQuery(query, null); // 위치 알려주는

            // Data 가 얼마나 있을지 모르니 While 문 : ArrayList가 아니라 StringBuffer 사용.
            StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext()){
                int count = cursor.getInt(0);

                stringBuffer.append(count);
                countResult = count;
            } // Data 다끝나면 끝
            textView.setText(stringBuffer.toString());

            // 사용 후에는 Close 해주기! 안해주면 종료.
            cursor.close();
            bookInfo.close();

            Toast.makeText(MainActivity.this, "Select OK!", Toast.LENGTH_SHORT).show();

            return countResult;
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Select Error!", Toast.LENGTH_SHORT).show();
            return 0;
        }
    }


    public void imageSetting(){
        int seedLevel = 0;
        seedLevel = countMyBook();

        if (seedLevel == 0){
            imageMySprout.setImageResource(R.drawable.seed);
        }else if(seedLevel >0 && seedLevel <5){
            imageMySprout.setImageResource(R.drawable.sprout);
        }else{
            imageMySprout.setImageResource(R.drawable.sprout_pngrepo_com);
        }


    }

}