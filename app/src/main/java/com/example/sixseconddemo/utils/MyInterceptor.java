package com.example.sixseconddemo.utils;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：author
 * 时间 ：2017/12/21:16:22
 * 说明：
 */

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        Log.i("---------", "intercept: "+proceed.toString());
        return null;
    }
}
