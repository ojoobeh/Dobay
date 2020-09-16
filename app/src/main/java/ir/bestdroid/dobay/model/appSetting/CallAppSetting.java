
package ir.bestdroid.dobay.model.appSetting;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
@SuppressWarnings("unused")
public class CallAppSetting {

    @SerializedName("data")
    @Expose
    private DataCallAppSetting data;

    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("success")
    @Expose
    private String success;

    public DataCallAppSetting getData() {
        return data;
    }

    public void setData(DataCallAppSetting data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

}
