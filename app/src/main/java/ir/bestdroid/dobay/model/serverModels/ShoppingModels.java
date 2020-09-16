package ir.bestdroid.dobay.model.serverModels;

import java.util.List;

public class ShoppingModels {

    private int issuccess;
    private String isshopping;
    private boolean success;
    private List<String> priceList;

    public int getIssuccess() {
        return issuccess;
    }

    public void setIssuccess(int issuccess) {
        this.issuccess = issuccess;
    }

    public String getIsshopping() {
        return isshopping;
    }

    public void setIsshopping(String isshopping) {
        this.isshopping = isshopping;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<String> priceList) {
        this.priceList = priceList;
    }
}
