package com.example.myloading;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Administrator on 2018/1/6.
 */

public class DialogUtils {
    private static final DialogUtils dialogUtils = new DialogUtils();
    LoadingDialog loadingDialog;
    Context mContext;

    public DialogUtils() {

    }


   void show(Context mContext){
       if (loadingDialog == null ) {
           loadingDialog = new LoadingDialog(mContext);
       }
       if (!loadingDialog.isShowing()){
           loadingDialog.show();
       }
    }
    public void dismiss(){
        if (loadingDialog != null&&loadingDialog.isShowing()) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

}
