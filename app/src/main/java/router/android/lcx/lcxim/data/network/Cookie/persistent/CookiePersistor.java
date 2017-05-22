package router.android.lcx.lcxim.data.network.Cookie.persistent;

import java.util.Collection;
import java.util.List;

import okhttp3.Cookie;

/**
 * Created by lichenxi on 2017/5/22.
 */

public interface CookiePersistor {

      List<Cookie> LoadAll();

      void SaveAll(Collection<Cookie> mCookie);

      void RemoveAll(Collection<Cookie> mCookie);

      void  clear();
}
