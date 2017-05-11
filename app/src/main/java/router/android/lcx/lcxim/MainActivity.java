package router.android.lcx.lcxim;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import router.android.lcx.lcxim.Base.BottomTabView;
import router.android.lcx.lcxim.MVP.Contact.ContactFragment;
import router.android.lcx.lcxim.MVP.Contact.ContactPresenter;
import router.android.lcx.lcxim.MVP.MineFragment;
import router.android.lcx.lcxim.MVP.NoFragment;
import router.android.lcx.lcxim.MVP.Session.SessionFragment;
import router.android.lcx.lcxim.MVP.Session.SessionPresenter;

public class MainActivity extends BottomBarActivity {
     private SessionFragment sessionFragment=new SessionFragment();
     private ContactFragment contactFragment=new ContactFragment();
     private NoFragment noFragment=new NoFragment();
     private MineFragment mineFragment=new MineFragment();

    @Override
    protected void doEvent() {
        super.doEvent();
        setAllPresenter();
    }

    private void setAllPresenter() {
          new SessionPresenter(sessionFragment);
          new ContactPresenter(contactFragment);
    }

    @Override
    protected List<BottomTabView.TabItem> getTabList() {
        List<BottomTabView.TabItem> tabItems = new ArrayList<>();
        tabItems.add(new BottomTabView.TabItem(this,"会话",R.color.textnoDefault,R.color.textSelect,
                      R.drawable.tab_chat,R.drawable.tab_chat_hover));
        tabItems.add(new BottomTabView.TabItem(this,"通讯录",R.color.textnoDefault,R.color.textSelect,
                R.drawable.tab_contacts,R.drawable.tab_contacts_hover));
        tabItems.add(new BottomTabView.TabItem(this,"待开发",R.color.textnoDefault,R.color.textSelect,
                R.drawable.tab_found,R.drawable.tab_found_hover));
        tabItems.add(new BottomTabView.TabItem(this,"我的",R.color.textnoDefault,R.color.textSelect,
                R.drawable.tab_me,R.drawable.tab_me_hover));
        return tabItems;
    }

    @Override
    protected List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(sessionFragment);
        fragments.add(contactFragment);
        fragments.add(noFragment);
        fragments.add(mineFragment);
        return fragments;
    }
}
