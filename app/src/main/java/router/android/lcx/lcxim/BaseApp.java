package router.android.lcx.lcxim;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class BaseApp extends Application {
     private  static Context mContext;//上下文
     private static  Handler mHandler;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        mHandler = new Handler();


    }

    public static Context getContext(){
        return mContext;
    }
    public static Handler getMainHandler() {
        return mHandler;
    }
}
