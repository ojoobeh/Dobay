
package ir.bestdroid.dobay.model.appSetting;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
@SuppressWarnings("unused")
public class DataCallAppSetting {

    @SerializedName("advertisement_visit")
    private String advertisementVisit;

    public String getAdvertisementVisit() {
        return advertisementVisit;
    }

    public void setAdvertisementVisit(String advertisementVisit) {
        this.advertisementVisit = advertisementVisit;
    }

}
