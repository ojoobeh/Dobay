package ir.bestdroid.dobay.model;

import java.util.List;

/**
 * Created by Aron on 6/4/2016.
 */

public class UserCallback {
    private String code;
    private String msg;
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
