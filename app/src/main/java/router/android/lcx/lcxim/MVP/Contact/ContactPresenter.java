package router.android.lcx.lcxim.MVP.Contact;

/**
 * Created by lichenxi on 2017/5/12.
 */

public class ContactPresenter implements ContactContracter.Presenter {
     private ContactContracter.View mView;

    public ContactPresenter(ContactContracter.View view) {
        this.mView=view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
