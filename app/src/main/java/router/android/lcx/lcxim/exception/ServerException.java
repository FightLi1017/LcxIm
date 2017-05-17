package router.android.lcx.lcxim.exception;

/**
 * Created by lichenxi on 2017/5/18.
 */

public class ServerException extends RuntimeException {
    private int code;
    private String msg;


    public ServerException(int code) {
        this(code,"");
    }
    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
