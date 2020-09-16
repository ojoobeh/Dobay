package ir.bestdroid.dobay.model.price;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Keep
public class PricesModels {


    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("details")
    String details;

    @SerializedName("date")
    String date;

    @SerializedName("video_type")
    String video_type;

    @SerializedName("video_file")
    String video_file;

    @SerializedName("photo_file")
    String photo_file;

    @SerializedName("audio_file")
    String audio_file;

    @SerializedName("icon")
    String icon;

    @SerializedName("visits")
    int visits;

    @SerializedName("href")
    String href;

    @SerializedName("fields_count")
    int fields_count;

    @SerializedName("fields")
    List<PriceDetailModels> fields;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    public String getVideo_file() {
        return video_file;
    }

    public void setVideo_file(String video_file) {
        this.video_file = video_file;
    }

    public String getPhoto_file() {
        return photo_file;
    }

    public void setPhoto_file(String photo_file) {
        this.photo_file = photo_file;
    }

    public String getAudio_file() {
        return audio_file;
    }

    public void setAudio_file(String audio_file) {
        this.audio_file = audio_file;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public int getFields_count() {
        return fields_count;
    }

    public void setFields_count(int fields_count) {
        this.fields_count = fields_count;
    }

    public List<PriceDetailModels> getFields() {
        return fields;
    }

    public void setFields(List<PriceDetailModels> fields) {
        this.fields = fields;
    }
}
