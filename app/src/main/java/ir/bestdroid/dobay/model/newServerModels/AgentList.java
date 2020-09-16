
package ir.bestdroid.dobay.model.newServerModels;

import androidx.annotation.Keep;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Keep
public class AgentList {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("bank_account")
    private String bankAccount;
    @SerializedName("created_at")
    private String createdAt;


    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("logo")
    @Expose
    private String logo;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("updated_at")
    private String updatedAt;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
