package com.example.administrator.zhihu.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.administrator.zhihu.R;
import com.example.administrator.zhihu.application.MyApplication;
import com.example.administrator.zhihu.db.MainTable;
import com.example.administrator.zhihu.model.MainAdapter;
import com.example.administrator.zhihu.util.Util;
import com.example.administrator.zhihu.util.VolleyCallback;
import com.example.administrator.zhihu.util.VolleyUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
public class MainActivity  extends Activity {
    public static List<MainTable> mainTableList = new ArrayList<MainTable>();
   public static ListView listView;
    public static Button button;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_layout);
            listView = (ListView) findViewById(R.id.main_listView);
        final LinearLayout  buttonView= (LinearLayout)LayoutInflater.from(this).inflate(R.layout.main_footer,null);
        button=(Button)buttonView.findViewById(R.id.main_button);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d("MainActivity", String.valueOf(position) + "ppppppppppppppppppppppppppppppppppppppp");
                    Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
                    String url = mainTableList.get(position).url;
                    intent.putExtra("extraData", "https://zhuanlan.zhihu.com/api/columns" + url);
                    startActivity(intent);
                }
            });


/*
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                VolleyUtil volleyUtil = new VolleyUtil();
                volleyUtil.getRequest("https://zhuanlan.zhihu.com/api/recommendations/columns?limit=10&offset=0&seed=46",
                        new VolleyCallback() {
                            @Override
                            public void onSuccess(JSONArray array) {
                                Log.d("MainActivity", array.length() + "************************************************");
                                mainTableList = Util.handleToMain(array);
                                Log.d("MainActivity", mainTableList.size() + "_________________________________________________________");
                                MainAdapter mainAdapter = new MainAdapter(MainActivity.this, R.layout.main_adapter, mainTableList);
                                Log.d("MainActivity", mainTableList.size() + "_______________________________________________________111");
                                listView.addFooterView(buttonView,null,false);
                                listView.setAdapter(mainAdapter);
                            }
                            @Override
                            public void onErrorOccur(VolleyError error) {
                            }
                            @Override
                            public void onSuccess2(JSONObject object){

                            }
                        });
            }
        });

*/
        VolleyUtil volleyUtil = new VolleyUtil();
        volleyUtil.getRequest("https://zhuanlan.zhihu.com/api/recommendations/columns?limit=10&offset=0&seed=46",
                new VolleyCallback() {
                    @Override
                    public void onSuccess(JSONArray array) {
                        Log.d("MainActivity", array.length() + "************************************************");
                        mainTableList = Util.handleToMain(array);
                        Log.d("MainActivity", mainTableList.size() + "_________________________________________________________");
                        MainAdapter mainAdapter = new MainAdapter(MainActivity.this, R.layout.main_adapter, mainTableList);
                        Log.d("MainActivity", mainTableList.size() + "_______________________________________________________111");
                        listView.addFooterView(buttonView,null,false);
                        listView.setAdapter(mainAdapter);
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
