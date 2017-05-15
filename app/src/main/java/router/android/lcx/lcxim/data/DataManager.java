package router.android.lcx.lcxim.data;

import android.content.Context;

import router.android.lcx.lcxim.data.network.DataApiStore;
import router.android.lcx.lcxim.data.network.model.Login;
import rx.Observable;

/**
 * Created by lichenxi on 2017/5/16.
 */

public class DataManager implements DataApiStore {
      private DataApiStore mDataApiStore;

    public DataManager(DataApiStore DataApiStore) {
       this.mDataApiStore=DataApiStore;
    }

    @Override
    public Observable<Login.LoginResponse> login(String region, String phone, String password) {
        return mDataApiStore.login(region,phone,password);
    }
}
