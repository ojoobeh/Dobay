
package ir.bestdroid.dobay.model.getLinkModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class CallGetLink {

    @SerializedName("code")
    private String mCode;
    @SerializedName("data")
    private DataGetLink mData;
    @SerializedName("msg")
    private String mMsg;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public DataGetLink getData() {
        return mData;
    }

    public void setData(DataGetLink data) {
        mData = data;
    }

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

}
