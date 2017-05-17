package router.android.lcx.lcxim.Common.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import router.android.lcx.lcxim.BaseApp;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class UiUtil {
    public static Toast mToast;

    public static void showToast(String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }

    public static void showToast(String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), "", duration);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 用于在线程中执行弹土司操作
     */
    public static void showToastSafely(final String msg) {
        getMainThreadHandler().post(new Runnable() {

            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);
                }
                mToast.setText(msg);
                mToast.show();
            }
        });
    }

    /**
     * 得到主线程Handler
     *
     * @return
     */
    public static Handler getMainThreadHandler() {
        return BaseApp.getMainHandler();
    }
    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return BaseApp.getContext();

    }

}
