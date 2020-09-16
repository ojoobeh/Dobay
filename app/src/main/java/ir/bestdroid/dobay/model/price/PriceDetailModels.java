package ir.bestdroid.dobay.model.price;

import com.google.gson.annotations.SerializedName;

public class PriceDetailModels {

    @SerializedName("type")
    int type;

    @SerializedName("title")
    String title;

    @SerializedName("value")
    String value;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
