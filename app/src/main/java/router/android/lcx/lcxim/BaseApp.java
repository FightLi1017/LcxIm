package router.android.lcx.lcxim;

import android.app.Application;
import android.content.Context;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class BaseApp extends Application {
     private  static Context mContext;//上下文
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }
}
