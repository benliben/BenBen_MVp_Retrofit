package com.android.benben.retrofitlibrary;

import rx.functions.Action1;

/**
 * Time      2017/4/5 10:10 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface ActionRequest<T> extends Action1<T>{
    void onError(String errorMsg, int statusCode);

    void finished();
}
