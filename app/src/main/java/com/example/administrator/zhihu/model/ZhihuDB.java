package com.example.administrator.zhihu.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.zhihu.db.MainTable;
import com.example.administrator.zhihu.db.MySQLHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class ZhihuDB {
    SQLiteDatabase db;
    static final String DB_NAME="Zhihu";
    MySQLHelper mySQLHelper;
    ZhihuDB zhihuDB;

    private ZhihuDB(Context context){
        mySQLHelper=new MySQLHelper(context,DB_NAME,null,1);
        db=mySQLHelper.getWritableDatabase();
    }
    public ZhihuDB  getInstance(Context context){
       return zhihuDB=new ZhihuDB(context);
    }

    public void saveToMain(MainTable mainTable){
            String title=mainTable.name;
            String preRead=mainTable.description;
            String followerCount=mainTable.description;
            String template=mainTable.avatar.template;

         String SAVE_MAIN="insert into table mainTable(title,preRead,followerCount,template) " +
                 "values(?,?,?,?)";
        db.execSQL(SAVE_MAIN,new String[]{title,preRead,followerCount,template});
    }
    public List loadMain(){
        ArrayList<MainTable> mainList=new ArrayList<MainTable>();
        Cursor cursor=db.rawQuery("select * from mainTable",null);
        if(cursor.moveToFirst())
            do{
                MainTable mainTable=new MainTable();
                mainTable.name=cursor.getString(0);
                mainTable.description=cursor.getString(1);
                mainTable.followersCount=cursor.getString(2);
                mainTable.avatar.template=cursor.getString(3);
                mainList.add(mainTable);
            }while(cursor.moveToNext());
        return mainList;
    }
}
