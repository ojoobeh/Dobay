
package ir.bestdroid.dobay.newModels.user;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
@Keep
public class DataUser {

    @Expose
    private int id;
    @Expose
    private String mobile;
    @Expose
    private String verify;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

}
