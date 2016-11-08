package com.example.administrator.zhihu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MySQLHelper extends SQLiteOpenHelper {
    public final static String CREATE_MAIN="create table mainTable(" +
            "id integer primary key autoincrement," +
            "title text," +
            "preRead text," +
            "followerCount text," +
            "url text)";


    public MySQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name, factory, version);
    }
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_MAIN);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }

}
