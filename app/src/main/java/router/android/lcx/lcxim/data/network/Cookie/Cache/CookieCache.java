package router.android.lcx.lcxim.data.network.Cookie.Cache;

import java.util.Collection;
import java.util.Iterator;

import okhttp3.Cookie;

/**
 * Created by lichenxi on 2017/5/22.
 */

public interface CookieCache {


    void addAll(Collection<Cookie> mCookies);

     void clear();

     Collection<Cookie> getCookie();

     void RemoveAll(Collection<Cookie> mCookie);

}
