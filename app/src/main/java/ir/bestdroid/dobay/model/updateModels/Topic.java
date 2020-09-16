
package ir.bestdroid.dobay.model.updateModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ir.bestdroid.dobay.model.newServerModels.DatumUser;

@SuppressWarnings("unused")
@Keep
public class Topic {

    @SerializedName("audio_file")
    private String mAudioFile;
    @SerializedName("date")
    private String mDate;
    @SerializedName("details")
    private String mDetails;
    @SerializedName("fields")
    private List<Field> mFields;
    @SerializedName("fields_count")
    private Long mFieldsCount;
    @SerializedName("href")
    private String mHref;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("id")
    private Long mId;
    @SerializedName("Joined_categories")
    private List<String> mJoinedCategories;
    @SerializedName("Joined_categories_count")
    private Long mJoinedCategoriesCount;
    @SerializedName("photo_file")
    private String mPhotoFile;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("user")
    private DatumUser mUser;
    @SerializedName("video_file")
    private String mVideoFile;
    @SerializedName("video_type")
    private String mVideoType;
    @SerializedName("visits")
    private Long mVisits;

    public String getAudioFile() {
        return mAudioFile;
    }

    public void setAudioFile(String audioFile) {
        mAudioFile = audioFile;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getDetails() {
        return mDetails;
    }

    public void setDetails(String details) {
        mDetails = details;
    }

    public List<Field> getFields() {
        return mFields;
    }

    public void setFields(List<Field> fields) {
        mFields = fields;
    }

    public Long getFieldsCount() {
        return mFieldsCount;
    }

    public void setFieldsCount(Long fieldsCount) {
        mFieldsCount = fieldsCount;
    }

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        mHref = href;
    }

    public Object getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<String> getJoinedCategories() {
        return mJoinedCategories;
    }

    public void setJoinedCategories(List<String> joinedCategories) {
        mJoinedCategories = joinedCategories;
    }

    public Long getJoinedCategoriesCount() {
        return mJoinedCategoriesCount;
    }

    public void setJoinedCategoriesCount(Long joinedCategoriesCount) {
        mJoinedCategoriesCount = joinedCategoriesCount;
    }

    public String getPhotoFile() {
        return mPhotoFile;
    }

    public void setPhotoFile(String photoFile) {
        mPhotoFile = photoFile;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public DatumUser getUser() {
        return mUser;
    }

    public void setUser(DatumUser user) {
        mUser = user;
    }

    public String getVideoFile() {
        return mVideoFile;
    }

    public void setVideoFile(String videoFile) {
        mVideoFile = videoFile;
    }

    public Object getVideoType() {
        return mVideoType;
    }

    public void setVideoType(String videoType) {
        mVideoType = videoType;
    }

    public Long getVisits() {
        return mVisits;
    }

    public void setVisits(Long visits) {
        mVisits = visits;
    }

}
