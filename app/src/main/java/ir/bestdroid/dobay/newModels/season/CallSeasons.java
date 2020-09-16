
package ir.bestdroid.dobay.newModels.season;

import androidx.annotation.Keep;

import java.util.List;
import com.google.gson.annotations.Expose;

@Keep
@SuppressWarnings("unused")
public class CallSeasons {

    @Expose
    private List<DataSeasons> data;
    @Expose
    private String message;
    @Expose
    private String status;

    public List<DataSeasons> getData() {
        return data;
    }

    public void setData(List<DataSeasons> data) {
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
