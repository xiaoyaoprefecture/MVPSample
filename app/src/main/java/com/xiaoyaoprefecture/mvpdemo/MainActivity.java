package com.xiaoyaoprefecture.mvpdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xiaoyaoprefecture.mvpdemo.mvp.MVPActivity;

public class MainActivity extends AppCompatActivity {
    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtn= (Button) findViewById(R.id.mBTn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MVPActivity.class));
            }
        });
    }
}
