package com.example.administrator.zhihu.application;

import android.app.Application;
import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/10/24.
 */
public class MyApplication extends Application {
    private static RequestQueue mQueue;
    private final static String QUE_TAG="REQUEST";
    private final static String QUE_TAG2="REQUEST2";
    private static Context context;
    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();
        mQueue= Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getmQueue(){
        return mQueue;
    }
    public static void addToQueue(JsonArrayRequest request){
        request.setTag(QUE_TAG);
        mQueue.add(request);
    }
    public static void addToQueue(JsonObjectRequest request){
        request.setTag(QUE_TAG2);
        mQueue.add(request);
    }
    public void queueCancel(){
        mQueue.cancelAll(QUE_TAG);
    }

    public static Context getContext(){
        return context;
    }
}
