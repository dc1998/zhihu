package com.example.administrator.zhihu.util;

import android.util.Log;

import com.example.administrator.zhihu.db.ArticleTable;
import com.example.administrator.zhihu.db.ContentTable;
import com.example.administrator.zhihu.db.MainTable;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class Util {
public static List<MainTable> mainTables;
    public static List<ArticleTable> articleTables;
    public static List handleToMain(JSONArray jsonArray){
        MainTable mainTable=new MainTable();
        Type listType=new TypeToken<ArrayList<MainTable>>(){}.getType();
        Gson gson=new Gson();
         mainTables=gson.fromJson(jsonArray.toString(),listType);
        List<MainTable> list=new ArrayList<MainTable>();

        Log.d("Util",mainTables.size()+"===============================");
       /* for(int i=0;i<jsonArray.length();i++){

            mainTable.name=mainTables.get(i).name;
            mainTable.description=mainTables.get(i).description;
            mainTable.followerCount=mainTables.get(i).followerCount;
            mainTable.avatar.template=mainTables.get(i).avatar.template;
            list.add(mainTable);
        }
        */
        return mainTables;

    }
    public static List handleToArticle(JSONArray jsonArray){
        ArticleTable articleTable=new ArticleTable();
        Type listType=new TypeToken<ArrayList<ArticleTable>>(){}.getType();
        Gson gson=new Gson();

        articleTables=gson.fromJson(jsonArray.toString(),listType);
        List<ArticleTable> list=new ArrayList<ArticleTable>();
        Log.d("Util",articleTables.size()+"===============================");
        return articleTables;
    }

    public static ContentTable handleToContent(JSONObject jsonObject){
        ContentTable contentTable=new ContentTable();
        Gson gson=new Gson();
        contentTable=gson.fromJson(jsonObject.toString(),ContentTable.class);
        return contentTable;
    }
}
