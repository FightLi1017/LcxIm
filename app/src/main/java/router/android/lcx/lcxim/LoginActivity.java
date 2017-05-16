package router.android.lcx.lcxim;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import okhttp3.RequestBody;;
import router.android.lcx.lcxim.Common.util.Inject;
import router.android.lcx.lcxim.data.DataManager;
import rx.functions.Action1;

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
                mDataManager.login("85","13650527163","123456")
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String response) {
                                 Log.d("lcx",response.toString());
                            }
                        });
            }
        });
    }

    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
        return body;
    }
}
