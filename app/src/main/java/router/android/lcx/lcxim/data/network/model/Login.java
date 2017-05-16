package router.android.lcx.lcxim.data.network.model;

/**
 * Created by lichenxi on 2017/5/15.
 */

public class Login {
   public static class LoginRequest{
          private String region;
          private String phone;
          private String password;
       public String getRegion() {
           return region;
       }

       public void setRegion(String region) {
           this.region = region;
       }

       public String getPhone() {
           return phone;
       }

       public void setPhone(String phone) {
           this.phone = phone;
       }

       public String getPassword() {
           return password;
       }

       public void setPassword(String password) {
           this.password = password;
       }
       @Override
       public String toString() {
           return "LoginRequest{" +
                   "region='" + region + '\'' +
                   ", phone='" + phone + '\'' +
                   ", password='" + password + '\'' +
                   '}';
       }

       public LoginRequest(String region, String phone, String password) {
           this.region = region;
           this.phone = phone;
           this.password = password;
       }

   }

    public static class LoginResponse{

    }
}
