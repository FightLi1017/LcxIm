package router.android.lcx.lcxim;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import router.android.lcx.lcxim.Base.BottomTabView;

public abstract class BottomBarActivity extends MenuBaseActivity {
     private  ViewPager mViewPager;
    private BottomTabView mBottomTabView;
    private FragmentPagerAdapter mAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        mToolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mViewPager=(ViewPager)findViewById(R.id.viewPager);
        mBottomTabView=(BottomTabView)findViewById(R.id.bottomTabView);
        mAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return getFragments().get(position);
            }

            @Override
            public int getCount() {
                return getFragments().size();
            }
        };
        mViewPager.setAdapter(mAdapter);

       if (getCenterView()!=null){
           mBottomTabView.setTabListitem(getTabList(),getCenterView());
       }else{
           mBottomTabView.setTabListitem(getTabList());
       }

        mBottomTabView.setOnTabItemSelectListener(new BottomTabView.OnTabItemSelectListener() {
            @Override
            public void onTabItemSelect(int position) {
                    doSomthing(position);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomTabView.updatePosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    protected abstract List<BottomTabView.TabItem> getTabList();
    protected abstract List<Fragment> getFragments();

    protected View getCenterView(){
        return null;
    }
    protected void doSomthing(int position){

    }
}
