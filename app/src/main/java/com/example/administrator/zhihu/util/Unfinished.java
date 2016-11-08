package com.example.administrator.zhihu.util;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.zhihu.R;
import com.squareup.picasso.Picasso;

import static com.example.administrator.zhihu.application.MyApplication.getContext;

/**
 * Created by Administrator on 2016/11/7.
 */
public class Unfinished {


    /*
    String followCount=mainTableList.get(position).followersCount;//transfer followerCount
    String description=mainTableList.get(position).description;
    String url2=mainTableList.get(position).avatar.template.substring(0,23)+mainTableList.get(position).avatar.id+
            mainTableList.get(position).avatar.template.substring(34);
    String name=mainTableList.get(position).name;

    intent.putExtra("extraData", "https://zhuanlan.zhihu.com/api/columns" + url);

    intent.putExtra("followCount",followCount);
    intent.putExtra("description",description);
    intent.putExtra("url2",url2);






    String followCount=getIntent().getStringExtra("followCount");
    String url2=getIntent().getStringExtra("url2");
    String description=getIntent().getStringExtra("description");
    String name=getIntent().getStringExtra("name");

    View titleView=(LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.article_title,null);
    ImageView articleTitleImage=(ImageView)findViewById(R.id.title_imageView);
    TextView articleTitle=(TextView)findViewById(R.id.title_name);
    TextView articleDescription=(TextView)findViewById(R.id.title_description);
    TextView articleFollowerCount=(TextView)findViewById(R.id.title_followerCount);

    if(articleTitleImage!=null)
            Picasso.with(getContext()).load(url2).into(articleTitleImage);
    Log.d("ArticleActivity",name+"1231231++++++++++++++++++++++++++++++++++++++");
    articleTitle.setText(name);
    articleDescription.setText(description);
    articleFollowerCount.setText(followCount);
    */
}
