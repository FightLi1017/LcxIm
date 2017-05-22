package router.android.lcx.lcxim.data.network;

import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import router.android.lcx.lcxim.BaseApp;
import router.android.lcx.lcxim.Common.util.NetUtils;
import router.android.lcx.lcxim.Common.util.UiUtil;
import router.android.lcx.lcxim.data.network.Cookie.Cache.SetCookieCache;
import router.android.lcx.lcxim.data.network.Cookie.PersistentCookieJar;
import router.android.lcx.lcxim.data.network.Cookie.persistent.SpCookiePersistor;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class ClientFactory {
    private static final int DISK_CACHE_SIZE = 50 * 1024 * 1024;
    private static final int TIME_OUT = 12;/*seconds*/
    private static volatile OkHttpClient INSTANCE;
      public static OkHttpClient getInstance(Context context){
          if (INSTANCE == null) {
              synchronized (ClientFactory.class) {
                  if (INSTANCE == null) {
                      INSTANCE=createHttpClient(context);
                  }
              }
          }
          return INSTANCE;
      }

    private static OkHttpClient createHttpClient(Context context) {
      OkHttpClient.Builder okHttpClient=new OkHttpClient.Builder();
        File cachefile=new File(context.getExternalCacheDir(),"http");
        Cache cache=new Cache(cachefile,DISK_CACHE_SIZE);

        PersistentCookieJar cookieJar=new PersistentCookieJar(new SetCookieCache(),new SpCookiePersistor(context));

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return okHttpClient.cache(cache)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(EADER_INTERCEPTOR)
                .cookieJar(cookieJar)
                .addInterceptor(CACHE_CONTROL_INTERCEPTOR)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

   static Interceptor EADER_INTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build();
            return chain.proceed(request);
        }
    };

    static Interceptor CACHE_CONTROL_INTERCEPTOR=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
           if (!NetUtils.isNetworkAvailable(BaseApp.getContext())){
                 request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                         .build();
                 UiUtil.showToastSafely("当前网络不可用");
           }

            Response originalResponse=chain.proceed(request);
            //pragma也是控制缓存的一个消息头属性 只是http1.0的遗留版本 也是做缓存的
           if (NetUtils.isNetworkAvailable(BaseApp.getContext())){
               //有网的情况
                  int maxAge=5;//缓存的时间
              return originalResponse.newBuilder()
                               .removeHeader("Pragma")
                       .header("Cache-Control", "public, max-age=" + maxAge)
                       .build();

           }else{
               //没网的情况
               //only-if-cached只接收缓存的内容
               int maxStale = 60 * 60 * 24 * 28;//tolerate 4-weeks stale
               return originalResponse.newBuilder()
                       .removeHeader("Prama")
                       //从缓存中获取资源 接收已经过期的响应
                       .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                       .build();

           }
        }
    };
}

