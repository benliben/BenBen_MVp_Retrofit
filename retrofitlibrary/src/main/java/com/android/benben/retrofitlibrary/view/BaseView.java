package com.android.benben.retrofitlibrary.view;

/**
 * Time      2017/4/5 10:05 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface BaseView {
    void showDialog();

    void showDialog(String dialogTitle,String dialogMsg);

    void hindDialog();

    void showToast(String msg);
}
