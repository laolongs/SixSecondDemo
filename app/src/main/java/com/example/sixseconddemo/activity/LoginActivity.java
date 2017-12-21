package com.example.sixseconddemo.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sixseconddemo.MainActivity;
import com.example.sixseconddemo.R;
import com.example.sixseconddemo.presenter.loginpresenter;
import com.example.sixseconddemo.view.ILoginview;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<loginpresenter> implements ILoginview {
    private final static String HEX = "ZXG1134504342";
    private final static String TRANSFORMATION = "DES/CBC/PKCS5Padding";//DES是加密方式 CBC是工作模式 PKCS5Padding是填充模式
    private final static String IVPARAMETERSPEC = "01020304";////初始化向量参数，AES 为16bytes. DES 为8bytes.
    private final static String ALGORITHM = "DES";//DES是加密方式
    private static final String SHA1PRNG = "SHA1PRNG";//// SHA1PRNG 强随机种子算法, 要区别4.2以上版本的调用方法
    public static final String ALGORITHM_DES = "DES/CBC/PKCS5Padding";
    loginpresenter log;
    String name="13522933723";
    String pw="cBGFQddcbI6hcev9hj9P6A==";
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_go)
    Button btGo;
    @BindView(R.id.cv)
    CardView cv;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private static String str_key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //13522933723   ZXG1134504342   cBGFQddcbI6hcev9hj9P6A==
        try {
            String encode = encode("12355678", HEX);
            Log.i("--------", "onCreate: "+encode);
            String decode = decode("12355678", encode);
            Log.i("--------", "onCreate: "+decode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createPresenter() {
        log=new loginpresenter(this);

    }

    public static String encode(String key, String data) throws Exception {
        return encode(key, data.getBytes());
    }

    private static String encode(String key, byte[] data) throws Exception {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, paramSpec);
            byte[] bytes = cipher.doFinal(data);
            return Base64.encodeToString(bytes, 0);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    private static byte[] decode(String key, byte[] data) throws Exception {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            // key的长度不能够小于8位字节
            Key secretKey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);
            IvParameterSpec iv = new IvParameterSpec("12345678".getBytes());
            AlgorithmParameterSpec paramSpec = iv;
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static String decode(String key, String data) {
        byte[] datas;
        String value = null;
        try {
            if (System.getProperty("os.name") != null
                    && (System.getProperty("os.name").equalsIgnoreCase("sunos") || System
                    .getProperty("os.name").equalsIgnoreCase("linux"))) {
                datas = decode(key, Base64.decode(data, 0));
            } else {
                datas = decode(key, Base64.decode(data, 0));
            }
            value = new String(datas);
        } catch (Exception e) {
            value = "";
        }
        return value;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick({R.id.bt_go, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_go:
                Explode explode = new Explode();
                explode.setDuration(500);
                getWindow().setExitTransition(explode);
                getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                Intent i2 = new Intent(this,MainActivity.class);
//                startActivity(i2, oc2.toBundle());
                log.getlogin();
                break;
            case R.id.fab:
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(this, fab, fab.getTransitionName());
                    startActivity(new Intent(this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(this, RegisterActivity.class));
                }
                break;
        }
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getPassword() {
        return pw;
    }
}
