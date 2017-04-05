package com.android.benben.retrofitlibrary.api;

import com.android.benben.retrofitlibrary.model.BaseModel;
import com.android.benben.retrofitlibrary.model.MoveModel;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Time      2017/4/5 10:21 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public interface ApiService {
    @POST("video")
    Observable<BaseModel<MoveModel>> watchMove(@Query("key")String key, @Query("q")String name);


}
