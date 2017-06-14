package com.xiaoyaoprefecture.mvpdemo.mvp;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 * view想要做什么
 *
 */

public interface MvpView {
    //显示下载进度
    void showLoading();
    //隐藏下载进度
    void dismissLoading();
    //listview中的item的初始化
    void setListItem(List<String>list);
    //Toast消息
    void showMessage(String s);
}
