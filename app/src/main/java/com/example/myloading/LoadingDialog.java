package com.example.myloading;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/6.
 */

public class LoadingDialog extends Dialog {
    private TextView tv_text;
    private ImageView loadingImage;
    private AnimationDrawable animation;

    public LoadingDialog(Context context) {
        super(context);
        /**设置对话框背景透明*/
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.loading);
        tv_text =  findViewById(R.id.tv_text);
        setCanceledOnTouchOutside(false);
        loadingImage =  findViewById(R.id.image);
        //加载动画资源
        animation = (AnimationDrawable) loadingImage.getDrawable();
        animation.start();
    }

    /**
     * 为加载进度个对话框设置不同的提示消息
     *
     * @param message 给用户展示的提示信息
     * @return build模式设计，可以链式调用
     */
    public LoadingDialog setMessage(String message) {
        tv_text.setText(message);
        return this;
    }
}
