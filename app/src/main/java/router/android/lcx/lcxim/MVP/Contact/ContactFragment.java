package router.android.lcx.lcxim.MVP.Contact;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import router.android.lcx.lcxim.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment  implements ContactContracter.View{
     private ContactContracter.Presenter mPresenter;


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }


    @Override
    public void setPresenter(ContactContracter.Presenter Presenter) {
        this.mPresenter=Presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

}
