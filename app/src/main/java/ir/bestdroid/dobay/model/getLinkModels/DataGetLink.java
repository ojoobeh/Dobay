
package ir.bestdroid.dobay.model.getLinkModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class DataGetLink {

    @SerializedName("link")
    private String mLink;
    @SerializedName("video")
    private String mVideo;

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        mLink = link;
    }

    public String getVideo() {
        return mVideo;
    }

    public void setVideo(String video) {
        mVideo = video;
    }

}
