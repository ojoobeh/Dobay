
package ir.bestdroid.dobay.model.questionModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;

import java.util.List;

@Keep
public class CallQuestion {

    @Expose
    private List<DataQuestion> data;
    @Expose
    private String msg;
    @Expose
    private String success;

    public List<DataQuestion> getData() {
        return data;
    }

    public void setData(List<DataQuestion> data) {
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
