package ir.bestdroid.dobay.model.serverModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Asrdigital on 02/03/2018.
 */
@Keep
public class NumberRequest {

    @SerializedName("success")
    boolean success;

    @SerializedName("numFound")
    int numFound;

    @SerializedName("isshopping")
    String isshopping;

    @SerializedName("issuccess")
    String issuccess;

    private List<String> priceList;


    public String getIsshopping() {
        return isshopping;
    }

    public void setIsshopping(String isshopping) {
        this.isshopping = isshopping;
    }

    public String getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(String issuccess) {
        this.issuccess = issuccess;
    }



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public List<String> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<String> priceList) {
        this.priceList = priceList;
    }
}
