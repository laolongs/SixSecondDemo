package com.example.sixseconddemo.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.example.sixseconddemo.MainActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 1. �����; ��װOkHttp3�Ĺ����� �õ������ģʽ
 * 2. @author forever
 * 3. @date 2017/9/6 09:19
 */

public class OkHttp3Utils {
    /**
     * ���� ��ȫ ��ͬ��
     * ˽�еľ�̬��Ա���� ֻ����������
     * ˽�еĹ��췽��
     * �ṩ����ʵ���ľ�̬����
     */
    private static OkHttpClient okHttpClient = null;


    public OkHttp3Utils() {
    }

    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            //��ͬ����ȫ
            synchronized (OkHttp3Utils.class) {
                if (okHttpClient == null) {
                    //�п� Ϊ�մ���ʵ��
                    // okHttpClient = new OkHttpClient();
/**
 * ��OkHttp2.x��������ǲ���ͨ��OkHttpClientֱ�����ó�ʱʱ��ͻ����ˣ�����ͨ��OkHttpClient.Builder�����ã�
 * ͨ��builder���ú�OkHttpClient����builder.build()������OkHttpClient��
 * ��������ͨ���������new OkHttpClient()���õ�OkHttpClient������ͨ��builder.build()��
 */
                    //  File sdcache = getExternalCacheDir();
                    File sdcache = new File(Environment.getExternalStorageDirectory(), "cache");
                    int cacheSize = 10 * 1024 * 1024;
                    okHttpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS).readTimeout(20, TimeUnit.SECONDS).cache(new Cache(sdcache.getAbsoluteFile(), cacheSize)).build();
                }
            }

        }

        return okHttpClient;
    }

    /**
     * get����
     * ����1 url
     * ����2 �ص�Callback
     */

    public static void doGet(String url, Callback callback) {

        //����OkHttpClient�������
        OkHttpClient okHttpClient = getInstance();
        //����Request
        Request request = new Request.Builder().url(url).build();
        //�õ�Call����
        Call call = okHttpClient.newCall(request);
        //ִ���첽����
        call.enqueue(callback);


    }

    /**
     * post����
     * ����1 url
     * ����2 �ص�Callback
     */

    public static void doPost(String url, Map<String, String> params, Callback callback) {

        //����OkHttpClient�������
        OkHttpClient okHttpClient = getInstance();
        //3.x�汾post���󻻳�FormBody ��װ��ֵ�Բ���

        FormBody.Builder builder = new FormBody.Builder();
        //��������
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));

        }


        //����Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }

    /**
     * post�����ϴ��ļ�
     * ����1 url
     * ����2 �ص�Callback
     */
    public static void uploadPic(String url, File file, String fileName) {
        //����OkHttpClient�������
        OkHttpClient okHttpClient = getInstance();
        //����RequestBody ��װfile����
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
        //����RequestBody �������͵�
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", fileName, fileBody).build();
        //����Request
        Request request = new Request.Builder().url(url).post(requestBody).build();

        //�õ�Call
        Call call = okHttpClient.newCall(request);
        //ִ������
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //�ϴ��ɹ��ص� Ŀǰ����Ҫ����
            }
        });

    }

    /**
     * Post������JSON����
     * ����һ������Url
     * �������������JSON
     * ������������ص�
     */
    public static void doPostJson(String url, String jsonParams, Callback callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);


    }

    /**
     * �����ļ� ��������ʽ��apkд���ָ���ļ� �õ�file����а�װ
     * ����һ������Url
     * �������������ļ���·����
     * �������������ļ����ļ���
     */
    public static void download(final MainActivity context, final String url, final String saveDir) {
        Request request = new Request.Builder().url(url).build();
        Call call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("xxx", e.toString());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    is = response.body().byteStream();
                    //apk����·��
                    final String fileDir = isExistDir(saveDir);
                    //�ļ�
                    File file = new File(fileDir, getNameFromUrl(url));
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context, "���سɹ�:" + fileDir + "," + getNameFromUrl(url), Toast.LENGTH_SHORT).show();
                        }
                    });
                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }

                    fos.flush();
                    //apk������ɺ� ����ϵͳ�İ�װ����
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    context.startActivity(intent);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) is.close();
                    if (fos != null) fos.close();


                }
            }
        });

    }

    /**
     * @param saveDir
     * @return
     * @throws IOException �ж�����Ŀ¼�Ƿ����
     */
    public static String isExistDir(String saveDir) throws IOException {
        // ����λ��
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            File downloadFile = new File(Environment.getExternalStorageDirectory(), saveDir);
            if (!downloadFile.mkdirs()) {
                downloadFile.createNewFile();
            }
            String savePath = downloadFile.getAbsolutePath();
            Log.e("savePath", savePath);
            return savePath;
        }
        return null;
    }

    /**
     * @param url
     * @return �����������н������ļ���
     */
    private static String getNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
