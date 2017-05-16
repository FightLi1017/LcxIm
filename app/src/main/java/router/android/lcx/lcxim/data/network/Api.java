package router.android.lcx.lcxim.data.network;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import router.android.lcx.lcxim.data.network.model.Login;
import rx.Observable;

/**
 * Created by lichenxi on 2017/5/16.
 */

public interface Api {
    //登录
    @POST("user/login")
    Observable<String> login(@Body RequestBody body);
    @POST("http://api.sealtalk.im/user/login")
    Call<String> login1(@Body RequestBody body);
}
