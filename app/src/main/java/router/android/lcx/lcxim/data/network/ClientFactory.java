package router.android.lcx.lcxim.data.network;

import android.content.Context;

import okhttp3.OkHttpClient;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class ClientFactory {
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

        return null;
    }
}

