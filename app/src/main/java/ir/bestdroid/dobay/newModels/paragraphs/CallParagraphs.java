
package ir.bestdroid.dobay.newModels.paragraphs;

import androidx.annotation.Keep;

import java.util.List;
import com.google.gson.annotations.Expose;

@Keep
@SuppressWarnings("unused")
public class CallParagraphs {

    @Expose
    private List<DataParagraphs> data;
    @Expose
    private String message;
    @Expose
    private String status;

    public List<DataParagraphs> getData() {
        return data;
    }

    public void setData(List<DataParagraphs> data) {
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
