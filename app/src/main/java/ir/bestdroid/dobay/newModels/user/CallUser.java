
package ir.bestdroid.dobay.newModels.user;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
@Keep
public class CallUser {

    @Expose
    private DataUser data;
    @Expose
    private String message;
    @Expose
    private String status;

    public DataUser getData() {
        return data;
    }

    public void setData(DataUser data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
