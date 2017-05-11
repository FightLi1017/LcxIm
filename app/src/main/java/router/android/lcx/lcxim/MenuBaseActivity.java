package router.android.lcx.lcxim;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

import router.android.lcx.lcxim.Base.BaseActivity;

public class MenuBaseActivity extends BaseActivity {

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {

                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    };
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.CreateGroup:
                Toast.makeText(MenuBaseActivity.this,"创建群组",Toast.LENGTH_SHORT).show();
                break;
            case R.id.addFriend:
                Toast.makeText(MenuBaseActivity.this,"添加朋友",Toast.LENGTH_SHORT).show();
                break;
            case R.id.startsession:
                Toast.makeText(MenuBaseActivity.this,"开启会话",Toast.LENGTH_SHORT).show();
                break;

            default:
                return false;
        }
        return true;
    }
}
