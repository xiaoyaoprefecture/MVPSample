package com.xiaoyaoprefecture.mvpdemo.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xiaoyaoprefecture.mvpdemo.R;

import java.util.List;

/**
 * view具体做的是什么
 */

public class MVPActivity extends AppCompatActivity implements MvpView,AdapterView.OnItemClickListener{
    ListView mvpListview;//listview
    MvpPresenter mvpPresenter;
    ProgressBar pb;//进度条

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mvpListview= (ListView) findViewById(R.id.mListView);
        mvpListview.setOnItemClickListener(this);
        pb= (ProgressBar) findViewById(R.id.mProgressBar);
        mvpPresenter=new MvpPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mvpPresenter.onResume();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        mvpPresenter.onItemClick(position);
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        pb.setVisibility(View.GONE);

    }

    @Override
    public void setListItem(List<String> list) {
        ArrayAdapter adapter=new ArrayAdapter(MVPActivity.this,android.R.layout.simple_list_item_1,list);
        mvpListview.setAdapter(adapter);
    }

    @Override
    public void showMessage(String s) {
        Toast.makeText(MVPActivity.this,s,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mvpPresenter.onDestroy();
        super.onDestroy();
    }
}
