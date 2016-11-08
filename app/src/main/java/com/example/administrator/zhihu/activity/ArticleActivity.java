package com.example.administrator.zhihu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.administrator.zhihu.R;
import com.example.administrator.zhihu.db.ArticleTable;
import com.example.administrator.zhihu.model.ArticleAdapter;
import com.example.administrator.zhihu.util.Util;
import com.example.administrator.zhihu.util.VolleyCallback;
import com.example.administrator.zhihu.util.VolleyUtil;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.administrator.zhihu.application.MyApplication.getContext;

/**
 * Created by Administrator on 2016/10/18.
 */
public class ArticleActivity extends Activity {
    ListView listView;
    List<ArticleTable> articleTablesList=new ArrayList<ArticleTable>();
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.article_layout);
        listView = (ListView) findViewById(R.id.article_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ArticleActivity.this, ContentActivity.class);
                String url=articleTablesList.get(position).url;
                String titleImageUrl=articleTablesList.get(position).titleImage;
                intent.putExtra("urlData","https://zhuanlan.zhihu.com/api/posts/"+url.substring(3));
                intent.putExtra("imageData",titleImageUrl);
                startActivity(intent);
            }
        });

        Intent intentGet = getIntent();
        url = getIntent().getStringExtra("extraData") + "/posts?limit=10&offset=0";

        Log.d("ArticleActivity", url);

        if (url != null) {
            VolleyUtil volleyUtil = new VolleyUtil();
            volleyUtil.getRequest(url, new VolleyCallback() {
                @Override
                public void onSuccess(JSONArray array) {
                    Log.d("ArticleActivity", array.length() + "************************************************");
                    articleTablesList = Util.handleToArticle(array);
                    Log.d("ArticleActivity", articleTablesList.size() + "_________________________________________________________");

                    ArticleAdapter adapter = new ArticleAdapter(ArticleActivity.this, R.layout.article_adapter
                            , articleTablesList);
                    Log.d("ArticleActivity", articleTablesList.size() + "_________________________________________________________");

                    listView.setAdapter(adapter);
                }

                @Override
                public void onErrorOccur(VolleyError error) {
                }
                @Override
                public void onSuccess2(JSONObject object){
                }
            });
        }
    }

}
