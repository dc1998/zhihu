package com.example.administrator.zhihu.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.zhihu.R;
import com.example.administrator.zhihu.application.MyApplication;
import com.example.administrator.zhihu.db.MainTable;
import com.example.administrator.zhihu.db.MySQLHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MainAdapter extends ArrayAdapter<MainTable> {
    int resourceId;
    public MainAdapter(Context context, int viewResourceId, List<MainTable> objects){
        super(context,viewResourceId,objects);
        resourceId=viewResourceId;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        MainTable mainTable=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder=new ViewHolder();
            viewHolder.titleImage=(ImageView)view.findViewById(R.id.mainImage_view);
            //change imageView to image By picasso
            viewHolder.title=(TextView)view.findViewById(R.id.main_title);
            viewHolder.preRead=(TextView)view.findViewById(R.id.main_preRead);
            viewHolder.followersCount=(TextView)view.findViewById(R.id.main_followercount);
            view.setTag(viewHolder);
        }
        else{
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.title.setText(mainTable.name);

        Log.d("MainAdapter",mainTable.followersCount+"ccccccccccccccccccccccccccc?cccccccccccccccccccccccccccccccccccccc");
        viewHolder.followersCount.setText(String.valueOf(mainTable.followersCount));
        if(mainTable.description.length()>15) {
            viewHolder.preRead.setText(mainTable.description.substring(0, 15)+"...");
        }
        else{
            viewHolder.preRead.setText(mainTable.description);
        }

        Picasso.with(getContext()).load(mainTable.avatar.template.substring(0,23)+mainTable.avatar.id+
        mainTable.avatar.template.substring(34)).into(viewHolder.titleImage);
        return view;
    }

}

class ViewHolder{
    TextView id;
    ImageView titleImage;
    TextView title;
    TextView preRead;
    TextView followersCount;
}
