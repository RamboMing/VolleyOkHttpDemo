package com.safewaychina.volleyokhttpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "http://www.mocky.io/v2/56c9d8c9110000c62f4e0bb0";

        GsonRequest<UserBean> request = new GsonRequest<UserBean>(url, new Response.Listener<UserBean>() {
            @Override
            public void onResponse(UserBean response) {
                Log.e(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, UserBean.class);
        HttpManager.getInstance(this).addRequest(request);

    }
}
