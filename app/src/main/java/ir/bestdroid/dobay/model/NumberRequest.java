package ir.bestdroid.dobay.model;

/**
 * Created by Asrdigital on 02/03/2018.
 */

public class NumberRequest {

    boolean success;
    int numFound;
    String isshopping;
    String issuccess;


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
}
