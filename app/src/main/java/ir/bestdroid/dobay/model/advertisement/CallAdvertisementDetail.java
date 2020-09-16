
package ir.bestdroid.dobay.model.advertisement;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
@SuppressWarnings("unused")
public class CallAdvertisementDetail {

    @SerializedName("data")
    @Expose
    private DataAdvertisementDetail data;

    @SerializedName("msg")
    @Expose
    private String msg;

    @SerializedName("success")
    @Expose
    private String success;

    public DataAdvertisementDetail getData() {
        return data;
    }

    public void setData(DataAdvertisementDetail data) {
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
