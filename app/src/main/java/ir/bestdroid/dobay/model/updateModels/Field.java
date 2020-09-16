
package ir.bestdroid.dobay.model.updateModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
@Keep
public class Field {

    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private Long mType;
    @SerializedName("value")
    private String mValue;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
