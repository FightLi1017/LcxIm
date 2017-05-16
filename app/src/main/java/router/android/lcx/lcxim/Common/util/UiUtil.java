package router.android.lcx.lcxim.Common.util;

import android.content.Context;
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
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return BaseApp.getContext();

    }

}
