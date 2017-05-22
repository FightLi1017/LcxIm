package router.android.lcx.lcxim.data.network.Cookie.persistent

import android.content.Context
import android.content.SharedPreferences
import okhttp3.Cookie
import java.util.*

/**
 * Created by lichenxi on 2017/5/22.
 */
class SpCookiePersistor private constructor(val sharedPreferences: SharedPreferences):CookiePersistor {

    constructor(context: Context):this(context.getSharedPreferences("Cookie",Context.MODE_PRIVATE)){}

    override fun LoadAll(): List<Cookie> {
        val Cookies=ArrayList<Cookie>(sharedPreferences.all.size)

        for ( value in sharedPreferences.all.entries){
                val values=value as String
                val cookie=SerializableCookie().decode(values)
                   if (cookie!=null){
                    Cookies.add(cookie)
                }

        }

       return Cookies
    }

    override fun SaveAll(cookies: Collection<Cookie>) {
        val editor = sharedPreferences.edit()
        for (cookie in cookies) {
            //把Cookie流话 保存在磁盘中
             editor.putString(createCookieKey(cookie),SerializableCookie().encode(cookie))
        }
        editor.commit()

    }


    override fun RemoveAll(cookies: Collection<Cookie>) {
        val editor = sharedPreferences.edit()
        for (cookie in cookies) {
            //把Cookie流话 保存在磁盘中
            editor.remove(createCookieKey(cookie))
        }
        editor.commit()
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun createCookieKey(cookie: Cookie): String {
        return (if (cookie.secure()) "https" else "http") + "://" + cookie.domain() + cookie.path() + "|" + cookie.name()
    }
}