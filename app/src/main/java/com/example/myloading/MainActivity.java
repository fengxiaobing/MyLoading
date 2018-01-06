package com.example.myloading;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private AnimationDrawable animationDrawable;
    LoadingDialog loadingDialog;
    DialogUtils dialogUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogUtils = new DialogUtils();
        loadingDialog = new LoadingDialog(MainActivity.this);
        imageView = findViewById(R.id.image);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imageView.setImageResource(R.drawable.animation1);
//                animationDrawable = (AnimationDrawable) imageView.getDrawable();
//
//                animationDrawable.start();
//                new LoadingDialog(MainActivity.this).show();
                String url = "http://tj.nineton.cn/Heart/index/all?city=CHSH000000";
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
//                builder.addInterceptor(new HttpParamInterceptor());
                OkHttpClient httpClient = builder.build();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                dialogUtils .show(MainActivity.this);
                httpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        String err = "请求失败";
                        dialogUtils.dismiss();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.e("TAG",response.body().string());
                        dialogUtils.dismiss();
                    }
                });


            }
        });
    }
}
