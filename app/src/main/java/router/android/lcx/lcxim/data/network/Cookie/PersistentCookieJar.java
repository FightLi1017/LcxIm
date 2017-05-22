package router.android.lcx.lcxim.data.network.Cookie;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import router.android.lcx.lcxim.data.network.Cookie.Cache.CookieCache;
import router.android.lcx.lcxim.data.network.Cookie.persistent.CookiePersistor;

/**
 * Created by lichenxi on 2017/5/23.
 */

public class PersistentCookieJar implements CookieJar {
     private CookieCache mCookieCache;
     private CookiePersistor mCookiePersistor;


    public PersistentCookieJar(CookieCache cache,CookiePersistor cookiePersistor) {
         this.mCookieCache=cache;
         this.mCookiePersistor=cookiePersistor;
         mCookieCache.addAll(mCookiePersistor.LoadAll());

    }
    //只保存当前会话结束后依然有效的Cookie
    private static List<Cookie> filterPersistentCookies(List<Cookie> cookies) {
        List<Cookie> persistentCookies = new ArrayList<>();
        for (Cookie cookie : cookies) {
            if (cookie.persistent()) {
                persistentCookies.add(cookie);
            }
        }
        return persistentCookies;
    }

    @Override
    synchronized public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
           mCookieCache.addAll(cookies);
           mCookiePersistor.SaveAll(filterPersistentCookies(cookies));
    }


    //判断当前的Cookie是否已经过期
    private static boolean isCookieExpired(Cookie cookie) {
        return cookie.expiresAt() < System.currentTimeMillis();
    }
    @Override
     synchronized public List<Cookie> loadForRequest(HttpUrl url) {
           List<Cookie> removeList=new ArrayList<>();
           List<Cookie> loadCook=new ArrayList<>();
        for (Cookie cookie:mCookieCache.getCookie()){
             if (isCookieExpired(cookie)){
                  removeList.add(cookie);
             }else if (cookie.matches(url)){
                 loadCook.add(cookie);
             }
        }
        mCookieCache.RemoveAll(removeList);
        mCookiePersistor.RemoveAll(removeList);
        return loadCook;
    }


}
