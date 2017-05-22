package router.android.lcx.lcxim.data.network.Cookie.Cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import okhttp3.Cookie;

/**
 * Created by lichenxi on 2017/5/22.
 */

public class SetCookieCache  implements CookieCache{

    private List<Cookie> mCookies;

    public SetCookieCache() {
        mCookies = new ArrayList<>();
    }

    @Override
    public void addAll(Collection<Cookie> mCookies) {
        mCookies.addAll(mCookies);
    }

    @Override
    public void clear() {
        mCookies.clear();
    }

    @Override
    public Collection<Cookie> getCookie() {
        return mCookies;
    }

    @Override
    public void RemoveAll(Collection<Cookie> mCookie) {
        mCookies.removeAll(mCookie);
    }
}
