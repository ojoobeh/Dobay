
package ir.bestdroid.dobay.model.updateModels;


import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Keep
@SuppressWarnings("unused")
public class CallBackHellp504 {

    @SerializedName("msg")
    private String mMsg;
    @SerializedName("section_id")
    private String mSectionId;
    @SerializedName("section_title")
    private String mSectionTitle;
    @SerializedName("topics")
    private List<Topic> mTopics;
    @SerializedName("topics_count")
    private Long mTopicsCount;
    @SerializedName("type")
    private Long mType;

    public String getMsg() {
        return mMsg;
    }

    public void setMsg(String msg) {
        mMsg = msg;
    }

    public String getSectionId() {
        return mSectionId;
    }

    public void setSectionId(String sectionId) {
        mSectionId = sectionId;
    }

    public String getSectionTitle() {
        return mSectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        mSectionTitle = sectionTitle;
    }

    public List<Topic> getTopics() {
        return mTopics;
    }

    public void setTopics(List<Topic> topics) {
        mTopics = topics;
    }

    public Long getTopicsCount() {
        return mTopicsCount;
    }

    public void setTopicsCount(Long topicsCount) {
        mTopicsCount = topicsCount;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

}
