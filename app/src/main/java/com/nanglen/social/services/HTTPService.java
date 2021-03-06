package com.nanglen.social.services;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class HTTPService {

    private Context context;
    private RequestQueue queue;
    private String BASE_URL = "http://188.166.180.204:8888/emergency.php";

    public HTTPService(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }

    public void callPHP(HashMap<String, String> params, final OnResponseCallback<JSONObject> responseCallback) {
        Log.d("HTTP", params.toString());

        StringRequest request = new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("HTTP", "onResponse " + s);

                try {
                    JSONObject json = new JSONObject(s);

                    responseCallback.onResponse(true, null, json);

                } catch (JSONException e) {
                    Log.d("HTTP", "JSONException " + e.getMessage());
                    e.printStackTrace();
                    responseCallback.onResponse(true, e, null);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("HTTP", "onErrorResponse " + volleyError);
                responseCallback.onResponse(false, volleyError, null);
            }
        });

        request.setParams(params);
        queue.add(request);
    }

    public interface OnResponseCallback<T> {
        void onResponse(boolean success, Throwable error, T data);
    }
}
