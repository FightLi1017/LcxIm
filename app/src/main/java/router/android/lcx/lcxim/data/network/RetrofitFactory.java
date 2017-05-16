package router.android.lcx.lcxim.data.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import router.android.lcx.lcxim.Common.util.Config;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class RetrofitFactory {
    private RetrofitFactory() {
    }
     private static volatile  Retrofit INSTANCE;
     public  static  Retrofit getInstance(Context context){
           if (INSTANCE==null){
                   synchronized (RetrofitFactory.class){
                       if (INSTANCE==null){
                           INSTANCE=createRetrofit(context);
                       }
                   }
           }
           return INSTANCE;
     }

    private static Retrofit createRetrofit(Context context) {
        return new Retrofit.Builder()
                .client(ClientFactory.getInstance(context))
                .baseUrl(Config.BASE_URL)
                 .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

}
