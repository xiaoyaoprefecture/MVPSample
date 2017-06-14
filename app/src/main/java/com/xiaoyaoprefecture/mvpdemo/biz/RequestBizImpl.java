package com.xiaoyaoprefecture.mvpdemo.biz;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/14.
 */

public class RequestBizImpl implements RequestBiz {
    @Override
    public void requestForData(final OnRequestListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    ArrayList<String>data=new ArrayList<String>();
                    for (int i=0;i<20;i++){
                        data.add("汤圆"+i);
                    }
                    if (null!=listener){
                        listener.onSuccess(data);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
