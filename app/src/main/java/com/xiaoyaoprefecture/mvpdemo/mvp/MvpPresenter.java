package com.xiaoyaoprefecture.mvpdemo.mvp;

import android.os.Handler;
import android.os.Looper;

import com.xiaoyaoprefecture.mvpdemo.biz.OnRequestListener;
import com.xiaoyaoprefecture.mvpdemo.biz.RequestBiz;
import com.xiaoyaoprefecture.mvpdemo.biz.RequestBizImpl;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 * view在什么时候去做什么
 */

public class MvpPresenter {
    private MvpView mvpView;
    private RequestBiz requestBiz;
    private Handler handler;
    public MvpPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
        requestBiz = new RequestBizImpl();
        handler = new Handler(Looper.getMainLooper());
    }
    public void onResume(){
        mvpView.showLoading();
        requestBiz.requestForData(new OnRequestListener() {
            @Override
            public void onSuccess(final   List<String> data) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mvpView.dismissLoading();
                        mvpView.setListItem(data);
                    }
                });

            }

            @Override
            public void onFail() {
                mvpView.showMessage("请求失败");
            }
        });
    }
    public void onItemClick(int position){
        mvpView.showMessage("点击了item"+position);
    }
    public void onDestroy(){
        mvpView=null;
    }
}
