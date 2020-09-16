package ir.bestdroid.dobay.model.copoun;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import ir.bestdroid.dobay.model.newServerModels.DatumUser;

@Keep
public class ActiveUserByCoupon {

    @SerializedName("success")
    String success;
    @SerializedName("msg")
    String msg;

    @SerializedName("data")
    DatumUser data;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DatumUser getData() {
        return data;
    }

    public void setData(DatumUser data) {
        this.data = data;
    }
}
