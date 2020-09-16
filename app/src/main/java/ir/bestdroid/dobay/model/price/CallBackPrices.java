package ir.bestdroid.dobay.model.price;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Keep
public class CallBackPrices {

    @SerializedName("msg")
    String msg;

    @SerializedName("section_id")
    String section_id;


    @SerializedName("section_title")
    String section_title;

    @SerializedName("type")
    int type;

    @SerializedName("topics_count")
    int topics_count;

    @SerializedName("topics")
    List<PricesModels> topics;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }

    public String getSection_title() {
        return section_title;
    }

    public void setSection_title(String section_title) {
        this.section_title = section_title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTopics_count() {
        return topics_count;
    }

    public void setTopics_count(int topics_count) {
        this.topics_count = topics_count;
    }

    public List<PricesModels> getTopics() {
        return topics;
    }

    public void setTopics(List<PricesModels> topics) {
        this.topics = topics;
    }
}
