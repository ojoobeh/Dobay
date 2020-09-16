
package ir.bestdroid.dobay.model.discountModel;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
@Keep
public class DataDiscount {

    @SerializedName("percent")
    private String mPercent;

    public String getPercent() {
        return mPercent;
    }

    public void setPercent(String percent) {
        mPercent = percent;
    }

}
