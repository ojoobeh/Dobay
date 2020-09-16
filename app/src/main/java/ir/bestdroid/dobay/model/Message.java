package ir.bestdroid.dobay.model;

/**
 * Created by Aron on 10/13/2015.
 */
public class Message {

    User user;
    String message;
    boolean success;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
