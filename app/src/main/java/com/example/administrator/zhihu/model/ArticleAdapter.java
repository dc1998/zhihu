package com.example.administrator.zhihu.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.zhihu.R;
import com.example.administrator.zhihu.db.ArticleTable;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class ArticleAdapter extends ArrayAdapter<ArticleTable> {
    int resourceId;
    public ArticleAdapter(Context context,int viewResourceId,List<ArticleTable> objects){
        super(context,viewResourceId,objects);
        resourceId=viewResourceId;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ArticleTable articleTable=getItem(position);
        ViewHolder viewHolder;
        View view;

        if( convertView==null){
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder.articleImage=(ImageView)view.findViewById(R.id.article_image);
            viewHolder.articleTitle=(TextView)view.findViewById(R.id.article_title);
            viewHolder.articleContent=(TextView)view.findViewById(R.id.article_preRead);
            viewHolder.articleLikesCount=(TextView)view.findViewById(R.id.article_likesCount);
            view.setTag(viewHolder);

        }
        else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.articleTitle.setText(articleTable.title);
        viewHolder.articleContent.setText(articleTable.content.substring(0,40)+"...查看全文>");
        viewHolder.articleLikesCount.setText(articleTable.likesCount+"赞");

        if(articleTable.titleImage!=null&&!articleTable.titleImage.isEmpty())
        Picasso.with(getContext()).load(articleTable.titleImage).into(viewHolder.articleImage);

        return view;


    }
     class ViewHolder{
        ImageView articleImage;
        TextView articleImageUrl;
        TextView  articleTitle;
        TextView articleContent;
        TextView articleLikesCount;


    }
}
