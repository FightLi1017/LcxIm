package router.android.lcx.lcxim.MVP.Session;

/**
 * Created by lichenxi on 2017/5/12.
 */

public class SessionPresenter implements SessionContract.Presenter {
     private SessionContract.View mView;

    public SessionPresenter(SessionContract.View view) {
        this.mView=view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
