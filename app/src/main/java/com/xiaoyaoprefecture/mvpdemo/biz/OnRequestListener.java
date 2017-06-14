package com.xiaoyaoprefecture.mvpdemo.biz;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface OnRequestListener {
    //请求数据成功的方法
    void onSuccess(List<String> data);
    //请求数据失败方法
    void onFail();
}
