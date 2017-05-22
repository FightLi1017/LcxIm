package router.android.lcx.lcxim.data.network.Cookie.persistent;

import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import okhttp3.Cookie;

/**
 * Created by lichenxi on 2017/5/23.
 */

public class SerializableCookie implements Serializable {

    private transient Cookie cookie;

      public String encode(Cookie cookie){
          this.cookie=cookie;
          ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
          ObjectOutputStream objectOutputStream=null;
          try {
              objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
              objectOutputStream.writeObject(this);
          } catch (IOException e) {
              e.printStackTrace();
          }finally {
                  try {
                      if (objectOutputStream!=null)
                      objectOutputStream.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }

          }

         return Base64encode(byteArrayOutputStream.toByteArray());

      }

     public Cookie decode(String encodedCookie)  {
          byte[] bytes=Base64decode(encodedCookie.getBytes());
         ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                 bytes);
         Cookie cookie = null;
         ObjectInputStream objectInputStream = null;
         try {
             objectInputStream=new ObjectInputStream(byteArrayInputStream);
             cookie=( (SerializableCookie)objectInputStream.readObject()).cookie;
         } catch (Exception e) {
             e.printStackTrace();
         }finally {
             if (objectInputStream != null) {
                 try {
                     objectInputStream.close();
                 } catch (IOException e) {

                 }
             }
         }
         return cookie;
     }

    /**
     * @param bytes
     * @return
     */
    private  byte[] Base64decode(final byte[] bytes) {
        return Base64.decode(bytes,Base64.DEFAULT);
    }

    /**
     * 二进制数据编码为BASE64字符串
     *
     * @param bytes
     * @return
     * @throws Exception
     */
    private  String Base64encode(final byte[] bytes) {
        return new String(Base64.encode(bytes,Base64.DEFAULT));
    }
}
