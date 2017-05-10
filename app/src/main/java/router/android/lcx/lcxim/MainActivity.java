package router.android.lcx.lcxim;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import router.android.lcx.lcxim.Base.BottomTabView;

public class MainActivity extends BottomBarActivity {

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
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        return fragments;
    }
}
