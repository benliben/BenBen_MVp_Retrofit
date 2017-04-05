package com.android.benben.retrofitlibrary;

import android.content.Context;
import android.util.Log;

import com.android.benben.retrofitlibrary.api.ApiService;
import com.android.benben.retrofitlibrary.exception.ApiException;
import com.android.benben.retrofitlibrary.exception.NotLoginThrowable;
import com.android.benben.retrofitlibrary.net.NetWork;
import com.android.benben.retrofitlibrary.view.BaseView;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Time      2017/4/5 10:07 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class MyRetrofitUtil {
    public static final String TAG = "MyRetrofitUtil";

    public static Retrofit sRetrofit;
    public static OkHttpClient sOkHttpClient;
    public static MyRetrofitUtil instance;

    private final static Object mRetrofitLock = new Object();

    private static Retrofit getRetrofit() {
        if (sRetrofit == null) synchronized (mRetrofitLock) {
            if (sRetrofit == null) {
                sRetrofit = new Retrofit.Builder()
                        .baseUrl(NetWork.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .client(okHttpClient())
                        .build();
            }
        }
        return sRetrofit;
    }

    public static MyRetrofitUtil getInstance() {
        if (instance == null) synchronized (MyRetrofitUtil.class) {
            if (instance == null) {
                instance = new MyRetrofitUtil();
            }
        }
        return instance;
    }

    public ApiService getApiService() {
        return get(ApiService.class);
    }

    public <T> T get(Class<T> tClass) {
        return getRetrofit().create(tClass);
    }


    private static HttpLoggingInterceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.v(TAG, message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    private static OkHttpClient okHttpClient() {
        sOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor())
//                .addInterceptor(new accountin)
                .build();
        return sOkHttpClient;
    }

    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io());
            }
        };
    }


    public static <T> Subscriber<T> newSubscriber(final Context context, final BaseView mView, final Action1<T> onNext) {
        final Subscriber<T> subscriber = new Subscriber<T>() {
            @Override
            public void onCompleted() {
                mView.hindDialog();
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "======error" + e.getMessage());
                mView.hindDialog();
                if (e instanceof ApiException) {
                    ApiException apiException = (ApiException) e;
                    mView.showToast(apiException.getError_message());
                } else if (e instanceof SocketTimeoutException) {
                    mView.showToast("网络请求超时，请重试");
                } else if (e instanceof NotLoginThrowable) {
                    mView.showToast("没有登陆，应跳往登陆界面");
                } else if (e instanceof ConnectException) {
                    mView.showToast("网络链接异常，请重试");
                } else {
                    mView.showToast("网络异常");
                }
                e.printStackTrace();
            }

            @Override
            public void onNext(T t) {
                if (!isUnsubscribed()) {
                    onNext.call(t);
                }

            }
        };
        return subscriber;
    }

    @Deprecated
    public static <T> Subscriber<T> newSubscriber(Context context, final BaseView mView, final CompositeSubscription mCompositeSubscription, final Action1<T> onNext) {

        return newSubscriber(context, mView, onNext);
    }

    public static <T> Subscriber<T> newSubscriber(final Context context, final ActionRequest<T> onNext) {
        Subscriber<T> subscriber = new Subscriber<T>() {
            @Override
            public void onCompleted() {
                onNext.finished();
            }

            @Override
            public void onError(Throwable e) {
                onNext.finished();
                String errorMessage = null;
                int statusCode = DEFAULT_STATUS_CODE;
                if (e instanceof ApiException) {
                    statusCode = ((ApiException) e).getError_code();
                    errorMessage = ((ApiException) e).getError_message();
                } else if (e instanceof NotLoginThrowable) {
                    unsubscribe();
                } else if (e instanceof SocketTimeoutException) {
                    errorMessage = "网络请求超时，请重试";
                } else if (e instanceof ConnectException) {
                    errorMessage = "网络链接异常，请重试";
                } else {
                    errorMessage = "网络异常";
                }
                onNext.onError(errorMessage, statusCode);
            }

            @Override
            public void onNext(T t) {
                if (!isUnsubscribed()) {
                    onNext.call(t);
                }
            }
        };
        return subscriber;
    }

    public static final int DEFAULT_STATUS_CODE = 95279527;

}
