package com.example.administrator.zhihu.util;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/10/24.
 */
public interface VolleyCallback {

    public void onSuccess(JSONArray array);
    public void onErrorOccur(VolleyError error);
    public void onSuccess2(JSONObject object);


}
