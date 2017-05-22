package router.android.lcx.lcxim.data.network;

import android.content.Context;

import com.google.gson.Gson;

import okhttp3.RequestBody;
import router.android.lcx.lcxim.data.network.model.Result;
import router.android.lcx.lcxim.data.network.model.Login;
import router.android.lcx.lcxim.exception.ExceptionEngine;
import router.android.lcx.lcxim.exception.ServerException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lichenxi on 2017/5/15.
 */
 //虽说 我们是用的Rxjava的方式 但是不一定非要是Retrfit的框架 这里我们就隔离了第三方的
// 以后要是换请求框架之后 我们也就只要从新写个iml类就可以了
public class DataApiStoreIml implements DataApiStore {
    private Api serviceApi;
    private static DataApiStoreIml INSTANCE=null;
     public static DataApiStore getInstance(Context context){
         if (INSTANCE==null){
             INSTANCE=new DataApiStoreIml(context);
         }
         return INSTANCE;
     }

    private DataApiStoreIml(Context context) {
        serviceApi=RetrofitFactory.getInstance(context).create(Api.class);
    }

    @Override
    public Observable<Login.LoginResponse> login(String region, String phone, String password) {
        return  serviceApi.login(getRequestBody(new Login.LoginRequest(region,phone,password)))
                                  .map(new ServerResultFunc<Login.LoginResponse>())
                                  .onErrorResumeNext(new HttpResultFunc<Login.LoginResponse>());

    }



    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        return body;
    }

    private class ServerResultFunc<T> implements Func1<Result<T>, T> {
        @Override
        public T call(Result<T> httpResult) {
            if (httpResult.code != 200) {
                throw new ServerException(httpResult.code);
            }
            return httpResult.result;
        }
    }

    private class HttpResultFunc<T> implements Func1<Throwable, Observable<T>> {
        @Override
        public Observable<T> call(Throwable throwable) {
            return Observable.error(ExceptionEngine.handleException(throwable));
        }
    }
}
