package router.android.lcx.lcxim.data.network.supportsubscribe;

import router.android.lcx.lcxim.exception.ApiException;
import rx.Subscriber;

/**
 * Created by lichenxi on 2017/5/18.
 */
 //可以扩展很多 eg 进度条的 dialog的 等很多
public abstract class netSubscribe<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
        doCompleted();
    }

    @Override
    public void onError(Throwable e) {
        onError( (ApiException) e,e.getMessage());
    }


    protected abstract void onError(ApiException ex,String message);


    protected void doCompleted(){

    }
}
