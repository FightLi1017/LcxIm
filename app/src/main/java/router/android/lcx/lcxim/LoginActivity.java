package router.android.lcx.lcxim;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

;
import router.android.lcx.lcxim.Common.util.Config;
import router.android.lcx.lcxim.Common.util.Inject;
import router.android.lcx.lcxim.Common.util.UiUtil;
import router.android.lcx.lcxim.data.DataManager;
import router.android.lcx.lcxim.data.network.model.Login;
import router.android.lcx.lcxim.data.network.supportsubscribe.netSubscribe;
import router.android.lcx.lcxim.exception.ApiException;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {
    private DataManager mDataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Context context=BaseApp.getContext();
        mDataManager= Inject.injectData(context);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataManager.login(Config.REGION,"13650527163","123456")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                         .subscribe(new netSubscribe<Login.LoginResponse>() {
                             @Override
                             protected void onError(ApiException ex,String exceptionname) {
                                 UiUtil.showToast(ex.getDisplayMessage()+exceptionname);
                             }

                             @Override
                             public void onNext(Login.LoginResponse response) {

                                 UiUtil.showToast(response.toString());
                             }
                         });

            }
        });
    }


}
