package router.android.lcx.lcxim.data.network.model;

/**
 * Created by lichenxi on 2017/5/17.
 */

public class Result<T> {
    public int code;
    public T result;

    public Result(int code, T result) {
        code = code;
        result = result;
    }
}
