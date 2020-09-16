package ir.bestdroid.dobay.model.serverModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import ir.bestdroid.dobay.model.newServerModels.DatumUser;

/**
 * Created by Aron on 10/13/2015.
 */
@Keep
public class Message  {

    @SerializedName("user")
    DatumUser user;

    @SerializedName("message")
    String message;

    @SerializedName("success")
    boolean success;


    public DatumUser getUser() {
        return user;
    }

    public void setUser(DatumUser user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
