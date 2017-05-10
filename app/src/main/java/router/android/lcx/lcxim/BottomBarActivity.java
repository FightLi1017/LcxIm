package router.android.lcx.lcxim;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import router.android.lcx.lcxim.Base.BottomTabView;

public abstract class BottomBarActivity extends AppCompatActivity {
     ViewPager mViewPager;
     BottomTabView mBottomTabView;
     FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        mViewPager=(ViewPager)findViewById(R.id.viewPager);
        mBottomTabView=(BottomTabView)findViewById(R.id.bottomTabView);
        adapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return getFragments().get(position);
            }

            @Override
            public int getCount() {
                return getFragments().size();
            }
        };
        mViewPager.setAdapter(adapter);

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
