package com.example.administrator.zhihu.db;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MainTable {

    public String followersCount;
    public  String name;
    public String url;
    public int postsCount;
    public String description;
    public Avatar avatar;
   /* public Avatar getAvatar(){
        return avatar;
    }
    */

    public static class Avatar{
        public String template;
        public String id;
    }
}
