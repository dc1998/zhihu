package com.example.administrator.zhihu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.android.volley.VolleyError;
import com.example.administrator.zhihu.R;
import com.example.administrator.zhihu.db.ContentTable;
import com.example.administrator.zhihu.util.Util;
import com.example.administrator.zhihu.util.VolleyCallback;
import com.example.administrator.zhihu.util.VolleyUtil;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/10/18.
 */
public class ContentActivity extends Activity {
    WebView webView;
    ContentTable contentTable;
    String url;
    String titleImageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_layout);
        webView=(WebView)findViewById(R.id.web_view);




        Intent getIntent=getIntent();
        url=getIntent.getStringExtra("urlData");
        titleImageUrl=getIntent.getStringExtra("titleImageUrl");

        VolleyUtil volleyUtil=new VolleyUtil();
        volleyUtil.getRequest2(url,new VolleyCallback(){
            @Override
            public void onSuccess(JSONArray array){

            }
            @Override
            public void onSuccess2(JSONObject object){
                contentTable=Util.handleToContent(object);
                Log.d("ContentActivity",contentTable.toString());
                WebSettings webSettings=webView.getSettings();
                webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                webView.loadDataWithBaseURL(null,contentTable.content,"text/html","UTF-8",null);

            }
            @Override
            public void onErrorOccur(VolleyError error){
            }
        });
    }
}
