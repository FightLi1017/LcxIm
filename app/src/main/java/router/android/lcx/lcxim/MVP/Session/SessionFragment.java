package router.android.lcx.lcxim.MVP.Session;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import router.android.lcx.lcxim.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SessionFragment extends Fragment implements SessionContract.View {
      private SessionContract.Presenter mPresenter;

    @Override
    public void setPresenter(SessionContract.Presenter Presenter) {
        mPresenter=Presenter;
    }

    public SessionFragment() {

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_session, container, false);
    }

}
