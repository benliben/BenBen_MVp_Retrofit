package com.android.benben.my_benben;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.benben.retrofitlibrary.view.BaseView;
import com.android.benben.retrofitlibrary.MyRetrofitUtil;
import com.android.benben.retrofitlibrary.api.ApiService;

/**
 * Time      2017/4/5 10:04 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class BaseActivity extends AppCompatActivity implements BaseView {
    private ProgressDialog mDialog;
    private Toast mToast;
    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        Log.i("BaseActivity", "当前的界面为"+getClass().getSimpleName());

    }

    @Override
    public void showDialog() {
        if (mDialog == null) {
            mDialog = new ProgressDialog(mContext);
            mDialog.show();
        } else if (!mDialog.isShowing()) {
            mDialog.show();
        }

    }

    @Override
    public void showDialog(String dialogTitle,String dialogMsg) {
        if (mDialog == null) {
            mDialog = new ProgressDialog(mContext);
            mDialog.setTitle(dialogTitle);
            mDialog.setMessage(dialogMsg);
            mDialog.show();
        } else if (!mDialog.isShowing()) {
            mDialog.setTitle(dialogTitle);
            mDialog.setMessage(dialogMsg);
            mDialog.show();
        }

    }

    @Override
    public void hindDialog() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }

    }

    @Override
    public void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
        }else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    protected ApiService beginService() {
        return MyRetrofitUtil.getInstance().get(ApiService.class);
    }


}
