package router.android.lcx.lcxim.data.network.model;

/**
 * Created by lichenxi on 2017/5/15.
 */

public class Login {
   public static class LoginRequest{
          private String region;
          private String phone;
          private String password;

       public LoginRequest(String region, String phone, String password) {
           this.region = region;
           this.phone = phone;
           this.password = password;
       }
   }

    public static class LoginResponse{

    }
}
