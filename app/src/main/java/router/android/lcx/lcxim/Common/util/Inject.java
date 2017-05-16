package router.android.lcx.lcxim.Common.util;

import android.content.Context;

import router.android.lcx.lcxim.data.DataManager;
import router.android.lcx.lcxim.data.network.DataApiStoreIml;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class Inject {
    public static DataManager injectData(Context context){
        return DataManager.getInstance(DataApiStoreIml.getInstance(context));
    }
}
