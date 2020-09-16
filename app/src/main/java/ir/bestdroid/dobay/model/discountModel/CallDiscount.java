
package ir.bestdroid.dobay.model.discountModel;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
@Keep
public class CallDiscount {

    @SerializedName("data")
    private DataDiscount mData;
    @SerializedName("msg")
    private String mMsg;
    @SerializedName("success")
    private String mSuccess;

    public DataDiscount getData() {
        return mData;
    }

    public void setData(DataDiscount data) {
        mData = data;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public String getSuccess() {
        return mSuccess;
    }

    public void setSuccess(String success) {
        mSuccess = success;
    }

}
