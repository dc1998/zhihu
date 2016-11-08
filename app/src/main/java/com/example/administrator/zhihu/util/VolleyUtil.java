package com.example.administrator.zhihu.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.zhihu.activity.ArticleActivity;
import com.example.administrator.zhihu.activity.MainActivity;
import com.example.administrator.zhihu.application.MyApplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URL;




/**
 * Created by Administrator on 2016/10/18.
 */
public class VolleyUtil {
    JsonArrayRequest jsonArrayRequest;

    public synchronized void getRequest(String url,final VolleyCallback callback){
        jsonArrayRequest=new JsonArrayRequest(url,new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray jsonArray){
                Log.d("VolleyUtil",jsonArray.length()+"________________________________");
                callback.onSuccess(jsonArray);

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error){
                callback.onErrorOccur(error);
            }
        });
        MyApplication.addToQueue(jsonArrayRequest);
    }

    public synchronized void getRequest2(String url,final VolleyCallback callback){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(url,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject object) {
                Log.d("VolleyUtil","getRequest2 excute_______________________________");
                callback.onSuccess2(object);
            }
            },

            new Response.ErrorListener(){
                @Override
                        public void onErrorResponse(VolleyError error){
                    callback.onErrorOccur(error);

                }
            });
        MyApplication.addToQueue(jsonObjectRequest);
    }

}
